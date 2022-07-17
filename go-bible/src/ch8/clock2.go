package ch8

import (
	"log"
	"net"
)

/*
一个顺序执行的时钟服务器，它会每隔一秒钟将当前时间写到客户端
*/

func Clock2Run() {
	listener, err := net.Listen("tcp", "localhost:8889")
	if err != nil {
		log.Fatal(err)
	}

	for {
		conn, err := listener.Accept()
		if err != nil {
			log.Print(err) // e.g., connection aborted
			continue
		}
		go handleConn(conn)
	}
}
