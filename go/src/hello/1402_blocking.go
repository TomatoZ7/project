package main

import (
	"fmt"
	"time"
)

func f1(in chan int) {
	fmt.Println(<-in)
}

func main() {
	out := make(chan int)
	go f1(out)
	out <- 2

	//out <- 2
	//go f1(out)
	time.Sleep(1 * 1e9)
}
