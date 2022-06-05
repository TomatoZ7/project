package main
//
//import "fmt"
//
//type Request struct {
//	a, b int
//	replyc chan int
//}
//
//type binOp func (a, b int) int
//
//func main() {
//	adder, quit := startServer(func(a, b int) int { return a + b })
//
//	const N = 100
//
//	var reqs [N]Request
//
//	for i := 0; i < N; i++ {
//		req := &reqs[i]
//		req.a = i
//		req.b = i + N
//		req.replyc = make(chan int)
//		adder <- req
//	}
//	quit<-true
//
//	for i := N-1; i >= 0; i-- {
//		if <-reqs[i].replyc != N + 2*i {
//			fmt.Println("fail at", i)
//		} else {
//			fmt.Println("Request ", i, " is ok!")
//		}
//	}
//
//	fmt.Println("done")
//}
//
//func startServer(op binOp) (chan *Request, chan bool) {
//	reqChan := make(chan *Request)
//	quit := make(chan bool)
//	go server(op, reqChan, quit)
//	return reqChan, quit
//}
//
//func server(op binOp, service chan *Request, quit chan bool) {
//	for {
//		select {
//		case req := <-service:
//			go run(op, req)
//		case <-quit:
//			return
//		}
//	}
//}
//
//func run(op binOp, req *Request) {
//	req.replyc <- op(req.a, req.b)
//}
