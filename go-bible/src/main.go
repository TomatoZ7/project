package main

import (
	"./ch5"
	"fmt"
)

func main()  {
	fmt.Println(ch5.Max(-11,-2,-3,-4))
	fmt.Println(ch5.Max([]int{-11, -2, -3, -4}...))
}
