package ch8

import (
	"log"
	"net"
	"os"
)

func NC2Run() {
	conn, err := net.Dial("tcp", "localhost:8005")
	if err != nil {
		log.Fatal(err)
	}
	defer conn.Close()
	go mustCopy(os.Stdout, conn)
	mustCopy(conn, os.Stdin)
}
