package ch8

import (
	"flag"
	"os"
	"path/filepath"
	"sync"
	"time"
)

/*
对每一个walkDir的调用创建一个新的goroutine。
它使用sync.WaitGroup 来对仍旧活跃的walkDir调用进行计数，另一个goroutine会在计数器减为零的时候将fileSizes这个channel关闭。
 */

func Du3Run() {
	// Determine the initial directories.
	flag.Parse()
	roots := make([]string, 10, 20)
	if len(os.Args) > 1 {
		roots = os.Args[1:]
	} else {
		roots = []string{"."}
	}

	fileSizes := make(chan int64)
	var n sync.WaitGroup
	for _, root := range roots {
		n.Add(1)
		go walkDirErupt(root, &n, fileSizes)
	}

	go func() {
		n.Wait()
		close(fileSizes)
	}()

	var tick <-chan time.Time
	if *verbose {
		tick = time.Tick(500 * time.Millisecond)
	}
	var nfiles, nbytes int64

loop:
	for {
		select {
		case size, ok := <-fileSizes:
			if !ok {
				break loop	// fileSizes was closed
			}
			nfiles++
			nbytes += size
		case <-tick:
			printDiskUsage(nfiles, nbytes)
		}
	}
	printDiskUsage(nfiles, nbytes)
}

func walkDirErupt(dir string, n *sync.WaitGroup, fileSize chan<- int64) {
	defer n.Done()
	for _, entry := range dirents(dir) {
		if entry.IsDir() {
			n.Add(1)
			subdir := filepath.Join(dir, entry.Name())
			go walkDirErupt(subdir, n, fileSize)
		} else {
			fileSize <- entry.Size()
		}
	}
}