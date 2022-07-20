package ch8

import (
	"flag"
	"os"
)

func Du1Run() {
	// Determine the initial directories.
	flag.Parse()
	roots := os.Args
	if len(roots) == 0 {
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

	// Print the results.
	var nfiles, nbytes int64
	for size := range fileSizes {
		nfiles++
		nbytes += size
	}

	printDiskUsage(nfiles, nbytes)
}