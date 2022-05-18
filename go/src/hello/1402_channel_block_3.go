package main

import (
	"fmt"
	"time"
)

// 为通道解除阻塞定义了 suck 函数来在无限循环中读取通道
func main() {
	ch3 := make(chan int)
	go suck3(ch3)
	time.Sleep(15 * 1e9)
	ch3 <- 77
	//fmt.Println(ch3)
}

func suck3(ch chan int) {
	for {
		fmt.Println(<-ch)
	}
}
