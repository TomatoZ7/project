package main

import "fmt"

func main() {
	str := "hello"
	c := []byte(str)
	c[0] = 'c'
	fmt.Println(string(c))
}