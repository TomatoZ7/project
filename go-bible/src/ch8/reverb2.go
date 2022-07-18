package ch8

import (
	"bufio"
	"log"
	"net"
	"sync"
	"time"
)

func R2Run() {
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

		go R2HandleConn(conn)
	}
}

func R2HandleConn(c net.Conn) {
	input := bufio.NewScanner(c)
	var wg sync.WaitGroup
	for input.Scan() {
		wg.Add(1)
		go echo(c, input.Text(), 3*time.Second)
	}
	wg.Wait()
	c.Close()
}