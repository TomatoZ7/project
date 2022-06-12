package main

import "fmt"

// 一个协程在无限循环中给通道发送整数数据。不过因为没有接收者，只输出了一个数字 0。
func main() {
	ch1 := make(chan int)
	go pump(ch1)
	fmt.Println(<-ch1)
}

func pump(ch chan int) {
	for i := 0; ; i++ {
		ch <- i
	}
}
