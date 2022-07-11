package ch7

import (
	"fmt"
	"io"
	"os"
)

/**
	写一个带有如下函数签名的函数CountingWriter，传入一个io.Writer接口类型，返回一个把原来的Writer封装在里面的新的Writer类型和一个表示新的写入字节数的int64类型指针。

	func CountingWriter(w io.Writer) (io.Writer, *int64)
 */

type CounterWriter struct {
	Writer io.Writer
	Count int
}

func (cw *CounterWriter) Write(content []byte) (int, error) {
	n, err := cw.Writer.Write(content)
	if err != nil {
		return n, err
	}
	cw.Count += n
	return n, nil
}

func CountingWriter(w io.Writer) (io.Writer, *int) {
	cw := CounterWriter{Writer: w}
	return &cw, &(cw.Count)
}

func CWRun() {
	cw, counter := CountingWriter(os.Stdout)
	_, _ = fmt.Fprintf(cw, "%s", "Print something to the screen")
	fmt.Println(*counter)
	_, _ = cw.Write([]byte("this is golang"))
	fmt.Println(*counter)
}
