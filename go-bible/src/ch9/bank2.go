package ch9

var (
	sema = make(chan struct{}, 1)
	balance int
)

func Deposit2(amount int) {
	sema <- struct{}{}		// acquire token
	balance = balance + amount
	<-sema		// release token
}

func Balance2() int {
	sema <- struct{}{}		// acquire token
	b := balance
	<-sema		// release token
	return b
}