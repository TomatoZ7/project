package main

import (
	"./ch4"
	"fmt"
)

func main()  {
	data := []int{1, 2, 3, 4, 5}
	fmt.Println(ch4.RotateByCycle(data, 2))
}
