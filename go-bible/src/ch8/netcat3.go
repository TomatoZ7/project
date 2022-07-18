package ch8

import (
	"io"
	"log"
	"net"
	"os"
)

func NC3Run() {
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
	conn.Close()
	<-done	// wait for background goroutine to finish
}
