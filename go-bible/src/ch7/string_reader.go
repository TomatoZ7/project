package ch7

import (
	"fmt"
	"io"
)

/**
strings.NewReader函数通过读取一个string参数返回一个满足io.Reader接口类型的值（和其它值）。
实现一个简单版本的NewReader，并用它来构造一个接收字符串输入的HTML解析器
 */

type StringReader struct {
	data string
	current int
}

func (sr *StringReader) Read(b []byte) (n int, err error) {
	// 不需要读取
	if len(b) == 0 {
		return 0, nil
	}
	n = copy(b, sr.data[sr.current:])
	if sr.current += n; sr.current >= len(sr.data) {
		// 已读完
		err = io.EOF
	}
	return
}

func NewReader(s string) *StringReader {
	sr := new(StringReader)
	sr.data = s
	return sr
}

func SRRun() {
	str := "Hello World, Hello Golang"
	sr := NewReader(str)
	data := make([]byte, 10)
	n, err := sr.Read(data[:0])
	for err == nil {
		n, err = sr.Read(data)
		fmt.Println(n, string(data[0:n]))
	}
}
