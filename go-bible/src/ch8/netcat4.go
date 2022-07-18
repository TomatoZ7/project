package ch8

import (
	"io"
	"log"
	"net"
	"os"
)

func NC4Run() {
	conn, err := net.Dial("tcp", "localhost:8040")
	if err != nil {
		log.Fatal(err)
	}
	done := make(chan struct{})
	go func() {
		io.Copy(os.Stdout, conn)
		log.Println("done")
		done <- struct{}{}
	}()
	mustCopy(conn, os.Stdin)
	// 类型断言，调用*net.TCPConn的方法CloseWrite()只关闭TCP的写连接
	cw := conn.(*net.TCPConn)
	cw.CloseWrite()
	<-done	// 阻塞等待后台 goroutine 完成接收channel
}
