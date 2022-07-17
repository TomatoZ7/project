package ch8

import (
	"io"
	"log"
	"net"
	"os"
)

/*
简单的telnet程序，用net.Dial就可以简单地创建一个TCP连接
 */

func mustCopy(dst io.Writer, src io.Reader) {
	if _, err := io.Copy(dst, src); err != nil {
		// 从链接中读取数据，并把读取到的内容写到标准输出中，直到遇到 end of file 的条件或者发生错误
		log.Fatal(err)
	}
}

func NCRun() {
	conn, err := net.Dial("tcp", "localhost:8889")
	if err != nil {
		log.Fatal(err)
	}
	defer conn.Close()
	mustCopy(os.Stdout, conn)
}