package ch8

import "fmt"

func PIP2Run() {
	naturals := make(chan int)
	squares := make(chan int)

	// Counter
	go func() {
		for x := 0; x < 100 ; x++ {
			naturals <- x
		}
		close(naturals)
	}()

	// Square
	go func() {
		for x := range naturals {
			squares <- x
		}
		close(squares)
	}()

	for x := range squares {
		fmt.Println(x)
	}
}