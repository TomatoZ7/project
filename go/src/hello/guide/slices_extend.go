package main

import "fmt"

func main() {
	//sliceExtend()
	reslicing()
}

func sliceExtend() {
	slice1 := make([]int, 5, 10)
	fmt.Println(slice1)
	slice1[1] = 5
	fmt.Println(slice1)

	// 扩容
	slice1 = slice1[0:len(slice1)+10]
	fmt.Println(slice1)
}

func reslicing() {
	s1 := make([]int, 0, 10)
	for i := 0; i < cap(s1); i++ {
		s1 = s1[0:i+1]
		s1[i] = i
		fmt.Printf("the length of slice is %d\n", len(s1))
	}

	// print the slice
	for i := 0; i < len(s1); i++ {
		fmt.Printf("Slice at %d is %d\n", i, s1[i])
	}

	s2 := s1[1:1]
	fmt.Println(len(s2))
	s3 := s1[1:2]
	fmt.Println(len(s3))
}
