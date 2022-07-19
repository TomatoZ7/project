package ch8

import (
	"bufio"
	"log"
	"net"
	"sync"
	"time"
)

/*
使用select来改造echo服务器，为其增加超时，这样服务器可以在客户端10秒中没有任何喊话时自动断开连接。
 */

func R3Run() {
	listener, err := net.Listen("tcp", "localhost:8040")
	if err != nil {
		log.Fatal(err)
	}

	for {
		conn, err := listener.Accept()
		if err != nil {
			log.Print(err) // e.g., connection aborted
			continue
		}

		go R3HandleConn(conn)
	}
}

func R3HandleConn(c net.Conn) {
	input := bufio.NewScanner(c)
	var wg sync.WaitGroup
	message := make(chan string)
	wg.Add(1)
	go func() {
		defer wg.Done()
		for {
			select {
			case <-time.After(10 * time.Second):
				c.Close()
			case msg := <-message:
				wg.Add(1)
				go echo(c, msg, 3*time.Second)
			}
		}
	}()
	for input.Scan() {
		message <- input.Text()
	}

	wg.Wait()
	c.Close()
}
