package ch9

import "sync"

var (
	mu sync.Mutex
	balance3 int
)

func Deposit3(amount int) {
	mu.Lock()
	defer mu.Unlock()
	balance += amount
}

func Balance3() int {
	mu.Lock()
	defer mu.Unlock()
	return balance
}
