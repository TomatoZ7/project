package ch7

import "io"

/**
io包里面的LimitReader函数接收一个io.Reader接口类型的r和字节数n，
并且返回另一个从r中读取字节但是当读完n个字节后就表示读到文件结束的Reader。
实现这个LimitReader函数：

func LimitReader(r io.Reader, n int64) io.Reader
 */

type LimitReader struct {
	io.Reader
}