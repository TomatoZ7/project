package ch7

import "os"

func TempRun() {
	for _, p := range os.Args[1:] {
		println(p)
	}
}
