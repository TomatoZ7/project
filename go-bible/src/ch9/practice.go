package ch9

import (
	"fmt"
	"time"
)

func P1Run() {
	chan1 := make(chan string)
	chan2 := make(chan string)
	times := 0

	go func() {
		for {
			chan1<-"ping"
		}
	}()

	go func() {
		for {
			chan2<-"ping"
		}
	}()

	go func() {
		for {
			select {
			case <-chan1:
				times++
			case <-chan2:
				times++
			}
		}
	}()

	for {
		fmt.Println(times)
		time.Sleep(3 * time.Second)
	}
}