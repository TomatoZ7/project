package ch7

import (
	"fmt"
	"io"
	"log"
	"strings"
)

/**
io包里面的LimitReader函数接收一个io.Reader接口类型的r和字节数n，
并且返回另一个从r中读取字节但是当读完n个字节后就表示读到文件结束的Reader。
实现这个LimitReader函数：

func LimitReader(r io.Reader, n int64) io.Reader
 */

type LimitReader struct {
	io.Reader
	N int	// 最多读取 N 个字符
}

func (lr *LimitReader) Read(b []byte) (n int, err error) {
	// 结束读取
	if lr.N <= 0 {
		err = io.EOF
		return
	}

	// 减少读取的长度
	if len(b) > lr.N {
		b = b[:lr.N]
	}

	n, err = lr.Reader.Read(b)
	lr.N -= n
	return
}

func LimitedReader(r io.Reader, n int) io.Reader {
	return &LimitReader{r, n}
}

func LRRun() {
	r := strings.NewReader("Hello World")
	lr := LimitedReader(r, 8)	// 限制每次最多读取 8 个字符

	b := make([]byte, 2)	// 每次读取 2 个字符

	for {
		n, err := lr.Read(b)
		if err != nil {
			if err == io.EOF {
				fmt.Println("文件已读取完")
				break
			}
			// 读取错误
			log.Fatalf("读取错误，%v", err)
		}
		fmt.Printf("本次读取%d个字符: %s\n", n, b[:])
	}
}