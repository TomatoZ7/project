package ch8

import (
	"flag"
	"os"
	"time"
)

/*
间歇打印内容，不过只有在调用时提供了-v的flag才会显示程序进度信息。
在roots目录上循环的后台goroutine在这里保持不变。
主goroutine现在使用了计时器来每500ms生成事件，
然后用select语句来等待文件大小的消息来更新总大小数据，或者一个计时器的事件来打印当前的总大小数据。
如果-v的flag在运行时没有传入的话，tick这个channel会保持为nil，这样在select里的case也就相当于被禁用了。
 */

var verbose = flag.Bool("v", true, "show verbose progress messages")

func Du2Run() {
	// Determine the initial directories.
	flag.Parse()
	roots := make([]string, 10, 20)
	if len(os.Args) > 1 {
		roots = os.Args[1:]
	} else {
		roots = []string{"."}
	}

	// Traverse the file tree.
	fileSizes := make(chan int64)
	go func() {
		for _, root := range roots {
			walkDir(root, fileSizes)
		}
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
