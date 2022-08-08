package main

import (
	"fmt"
	"time"
)

func main() {
	ch := make(chan int)

	go worker(ch)

	for i := 0; i < 5000; i++ {
		ch <- i
	}

	close(ch)

	fmt.Println("okok")
}

func worker(ch chan int) {
	time.Sleep(time.Second * 5)
	for {
		fmt.Println(<-ch)
	}
}
