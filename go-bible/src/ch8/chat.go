package ch8

import (
	"bufio"
	"fmt"
	"log"
	"net"
)

/*
这个程序可以让一些用户通过服务器向其它所有用户广播文本消息。
这个程序中有四种goroutine。
main和broadcaster各自是一个goroutine实例，每一个客户端的连接都会有一个handleConn和clientWriter的goroutine。
broadcaster是select用法的不错的样例，因为它需要处理三种不同类型的消息。
 */

type client chan<- string

var (
	entering = make(chan client)
	leaving = make(chan client)
	messages = make(chan string)	// all incoming client messages
)

func ChatRun() {
	listener, err := net.Listen("tcp", "localhost:8777")
	if err != nil {
		log.Fatal(err)
	}
	go broadcaster()
	for {
		conn, err := listener.Accept()
		if err != nil {
			log.Print(err)
			continue
		}
		go handleChatConn(conn)
	}
}

func broadcaster() {
	clients := make(map[client]bool)	// all connected clients
	for {
		select {
		case msg := <-messages:
			for cli := range clients {
				cli <- msg
			}
		case cli := <-entering:
			clients[cli] = true
		case cli := <-leaving:
			delete(clients, cli)
			close(cli)
		}
	}
}

func handleChatConn(c net.Conn) {
	ch := make(chan string) // outgoing client messages
	go clientWriter(c, ch)

	who := c.RemoteAddr().String()
	ch <- "You are " + who
	messages <- who + " has arrived"
	entering <- ch

	input := bufio.NewScanner(c)
	for input.Scan() {
		messages <- who + ": " + input.Text()
	}

	leaving <- ch
	messages <- who + " has left"
	c.Close()
}

func clientWriter(c net.Conn, ch <-chan string) {
	for msg := range ch {
		fmt.Fprintln(c, msg)
	}
}