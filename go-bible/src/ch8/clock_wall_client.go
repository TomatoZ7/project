package ch8

import (
	"flag"
	"fmt"
	"log"
	"net"
	"os"
	"time"
)

func dail(port string) {
	domain := "localhost:" + port
	fmt.Print(domain)
	conn, err := net.Dial("tcp", domain)
	if err != nil {
		log.Fatal(err)
	}
	mustCopy(os.Stdout, conn)
	defer conn.Close()
}


func CWCRun() {
	flag.Parse()
	for _, port := range os.Args[1:] {	// 获取输入，xxx 8001 8002 8003
		go dail(port)
	}

	for {
		time.Sleep(5 * time.Second)
	}
}