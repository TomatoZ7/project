package main

import "time"

func fn1() {

	ch := make(chan int) // no buffer
	go func() {
		ch <- 0
		println("out of routine")
	}()
	println("f1 start")
	time.Sleep(time.Second * 3)
	<-ch
	println("End")

}

func fn2() {
	ch := make(chan int, 1) // size =1
	go func() {
		ch <- 0
		println("out of routine")
	}()
	println("f1 start")
	time.Sleep(time.Second * 3)
	<-ch
	println("End")

}

func main() {
	//fn1()
	fn2()
}
