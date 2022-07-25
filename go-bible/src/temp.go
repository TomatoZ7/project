package main

import (
	"fmt"
	"time"
)

func main() {
	ready := make(chan int)

	go func() {
		time.Sleep(5 * time.Second)

		close(ready)
	}()

	res := <-ready
	fmt.Println(res)
}
