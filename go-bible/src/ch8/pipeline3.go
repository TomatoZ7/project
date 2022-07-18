package ch8

import "fmt"

func counter(out chan<- int) {
	for i := 0; i < 100; i++ {
		out <- i
	}
	close(out)
}

func square(out <-chan int, in chan<- int) {
	for v := range out {
		in <- v
	}
	close(in)
}

func printer(in <-chan int) {
	for v := range in {
		fmt.Println(v)
	}
}

func PIP3Run() {
	naturals := make(chan int)
	squares := make(chan int)

	go counter(naturals)
	go square(naturals, squares)
	printer(squares)
}
