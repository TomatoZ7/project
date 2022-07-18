package ch8

import (
	"log"
	"net"
	"os"
)

/*
简单的telnet程序，用net.Dial就可以简单地创建一个TCP连接
 */

func NCRun() {
	conn, err := net.Dial("tcp", "localhost:8889")
	if err != nil {
		log.Fatal(err)
	}
	defer conn.Close()
	mustCopy(os.Stdout, conn)
}