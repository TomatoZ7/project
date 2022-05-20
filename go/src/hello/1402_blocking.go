package main

import (
	"fmt"
	"time"
)

func f1(in chan int) {
	fmt.Println(<-in)
}

func f2(ch chan int) {
	for i := 0; i < 10; i++ {
		ch <- i
	}
}

func main() {
	out := make(chan int)
	// pass
	//go f1(out)
	//out <- 2

	// deadlock
	//out <- 2
	//go f1(out)

	// deadlock
	//fmt.Println(<-out)
	//go f2(out)

	// pass
	go f2(out)
	for i := 0; i < 10; i++ {
		fmt.Println(<-out)
	}
	time.Sleep(1 * 1e9)
}
