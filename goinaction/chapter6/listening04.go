package main

import (
	"fmt"
	"runtime"
	"sync"
	"time"
)

var wg sync.WaitGroup

func main() {
	// 分配一个逻辑处理器给调度器使用
	runtime.GOMAXPROCS(1)

	// 计数+2，表示要等待2个goroutine
	wg.Add(2)

	// 创建 2 个 goroutine
	fmt.Println("Create Goroutines")
	go printPrime("A")
	go printPrime("B")

	// 等待 goroutine 结束
	fmt.Println("Waiting To Finish")
	wg.Wait()

	fmt.Println("Terminating Program")
}

func printPrime(prefix string) {
	defer wg.Done()

	time.Sleep(10 * time.Second)

	next:
		for outer := 2; outer < 5000; outer++ {
			for inner := 2; inner < 5000; inner++ {
				if outer%inner == 0 {
					continue next
				}
			}
			fmt.Printf("%s:%d\n", prefix, outer)
		}
}
