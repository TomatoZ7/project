package ch8

import (
	"io"
	"log"
	"net"
	"os"
	"time"
)

func CWSRun() {
	if len(os.Args) > 1 {
		port := os.Args[1]
		listen(port)
	}
}

func listen(port string) {
	domain := "localhost:" + port
	listener, err := net.Listen("tcp", domain)
	if err != nil {
		log.Fatal(err)
	}

	for {	// 一直循环，直到创建新的对象，这样得到原来的对象
		conn, err := listener.Accept()
		if err != nil {
			log.Print(err)
			continue
		}
		// 连接成功，解决链接，此时只允许一个 client
		cwsHandleConn(conn, port)
	}
}

/**
 * 用于处理一个完整的客户端连接
 */
func cwsHandleConn(c net.Conn, port string) {
	defer c.Close()
	for {
		ss := time.Now().Format("15:04:03  ") + port + "\n"
		_, err := io.WriteString(c, ss)
		if err != nil {
			return 	// e.g., client disconnected
		}
		time.Sleep(3 * time.Second)
	}
}