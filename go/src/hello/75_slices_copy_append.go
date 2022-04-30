package main

import "fmt"

func main() {
	//copyAppendSlice()

	//s1 := []byte{'a', 'b', 'c'}
	//fmt.Println(len(s1), cap(s1))
	//s2 := AppendByte(s1, 'e', 'f', 'g')
	//fmt.Println(s2)

	// practice 1 给定 slice s[]int 和一个 int 类型的因子 factor，扩展 s 使其长度为 len(s) * factor。
	//s3 := make([]int, 3, 3)
	//s4 := Practice1(s3, 3)
	//fmt.Println(s4, len(s4), cap(s4))

	// practice 2 写一个函数 InsertStringSlice 将切片插入到另一个切片的指定位置。
	s5 := make([]int, 10, 10)
	s6 := make([]int, 3, 3)
	InsertStringSlice(s5, s6, 5)
}

func copyAppendSlice() {
	slFrom := []int{1, 2, 3}
	slTo := make([]int, 10)

	n := copy(slTo, slFrom)
	fmt.Println(slTo)
	fmt.Printf("Copied %d elements\n", n)	// n == 3

	sl3 := []int{1, 2, 3}
	sl3 = append(sl3, 4, 5, 6)
	fmt.Println(sl3)
}

func AppendByte(slice []byte, data ...byte) []byte {
	m := len(slice)
	n := m + len(data)
	if n > cap(slice) {		// if necessary, reallocate
		newSlice := make([]byte, (n+1)*2)
		copy(newSlice, slice)
		slice = newSlice
	}
	slice = slice[0:n]
	copy(slice[m:n], data)
	return slice
}

func Practice1(slice []int, factor int) []int {
	newSlice := make([]int, len(slice) * factor, len(slice) * factor)
	copy(newSlice, slice)
	slice = newSlice

	return slice
}

func InsertStringSlice(sliceTarget []int, sliceSource []int, site int) {
	//newSlice := make([]int, len(sliceTarget) + len(sliceSource), cap(sliceTarget) + cap(sliceSource))
	newSlice := append(sliceTarget[:site], sliceSource...)
	newSlice = append(newSlice, sliceTarget[site:]...)
	fmt.Println(newSlice)
}
