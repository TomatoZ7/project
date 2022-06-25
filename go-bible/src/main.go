package main

import "fmt"
import "./ch4"

func main()  {
	s := []int{1,2,3,4,5,6,7,8,9,10}
	ch4.Reserve(s)
	fmt.Println(s)
}
