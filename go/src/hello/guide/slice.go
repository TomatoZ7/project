package main

import "fmt"

func main() {
	fmt.Println(make([]int, 50, 100))
	fmt.Println(new([100]int)[0:50])
}
