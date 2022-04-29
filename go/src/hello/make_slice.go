package main

import "fmt"

func main() {
	//给定切片 sl，将一个 []byte 数组追加到 sl 后面。写一个函数 Append(slice, data []byte) []byte，该函数在 sl 不能存储更多数据的时候自动扩容。
	s := make([]byte, 5)
	d := []byte{'a', 'b', 'c', 'd', 'e', 'f', 'g'}
	Append(s, d)
}

func Append(slice, data []byte) {
	for i := 0; i < len(data); i++ {
		//slice[i] = data[i]

		slice = append(slice, data[i])
	}

	fmt.Println(slice)
}
