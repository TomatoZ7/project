package ch8

import (
	"fmt"
	"io"
	"log"
	"net"
	"strings"
	"time"
)

func mustCopy(dst io.Writer, src io.Reader) {
	if _, err := io.Copy(dst, src); err != nil {
		// 从链接中读取数据，并把读取到的内容写到标准输出中，直到遇到 end of file 的条件或者发生错误
		log.Fatal(err)
	}
}

func echo(c net.Conn, shout string, delay time.Duration) {
	fmt.Fprintln(c, "\t", strings.ToUpper(shout))
	time.Sleep(delay)
	fmt.Fprintln(c, "\t", shout)
	time.Sleep(delay)
	fmt.Fprintln(c, "\t", strings.ToLower(shout))
}
