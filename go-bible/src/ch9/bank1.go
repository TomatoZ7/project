package ch9

import (
	"fmt"
	"sync"
)

var deposits = make(chan int)	 // 存款用的 channel
var balances = make(chan int) 	 // 接收余额用的 channel

func Deposit(amount int) {
	deposits <- amount
}

func Balance() int {
	return <-balances
}

/*
1.总余额限定在一个goroutine中,通过channel通讯
2.channel是会阻塞同一时间的多个 goroutine
 */
func teller() {
	var balance int
	for {
		select {
		case amount := <-deposits:
			balance += amount
		case balances <- balance:
		}
	}
}

func Bank1Run() {
	go teller()

	var wg sync.WaitGroup
	wg.Add(1)
	go func() {
		defer wg.Done()
		Deposit(100)
		fmt.Println("=", Balance())
	}()

	wg.Add(1)
	go func() {
		defer wg.Done()
		Deposit(200)
		fmt.Println("=", Balance())
	}()

	wg.Add(1)
	go func(){
		defer wg.Done()
		res := withDraw(200)
		if !res{
			fmt.Println("取款失败")
		}
	}()

	wg.Wait()
	b:=Balance()
	fmt.Println(b)
}

func withDraw(amount int) bool {
	Deposit(-amount)
	if Balance() < 0 {
		Deposit(amount)
		return false
	}
	return true
}