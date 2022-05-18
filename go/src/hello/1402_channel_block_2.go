package main

import (
	"fmt"
	"time"
)

// 为通道解除阻塞定义了 suck 函数来在无限循环中读取通道
func main() {
	ch2 := make(chan int)
	go pump2(ch2)
	go suck2(ch2)
	time.Sleep(1e9)
}

func pump2(ch chan int) {
	for i := 0; ; i++ {
		ch <- i
	}
}

func suck2(ch chan int) {
	for {
		fmt.Println(<-ch)
	}
}
