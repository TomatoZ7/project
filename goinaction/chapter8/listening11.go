// 创建定制的日志记录器
package main

import (
	"io"
	"io/ioutil"
	"log"
	"os"
)

var (
	Trace *log.Logger	// 记录所有日志
	Info *log.Logger	// 重要的信息
	Warning *log.Logger	// 需要注意的信息
	Error *log.Logger	// 非常严重的问题
)

func init() {
	file, err := os.OpenFile("error.txt", os.O_CREATE|os.O_WRONLY|os.O_APPEND, 0666)
	if err != nil {
		log.Fatalln("Fail to open error log file:", err)
	}

	Trace = log.New(ioutil.Discard, "TRACE:", log.Ldate|log.Ltime|log.Llongfile)

	Info = log.New(os.Stdout, "INFO:", log.Ldate|log.Ltime|log.Llongfile)

	Warning = log.New(os.Stdout, "WARNING:", log.Ldate|log.Ltime|log.Llongfile)

	Error = log.New(io.MultiWriter(file, os.Stderr), "ERROR:", log.Ldate|log.Ltime|log.Llongfile)
}

func main() {
	Trace.Println("trace message")

	Info.Println("info message")

	Warning.Println("warning message")

	Error.Println("error message")
}