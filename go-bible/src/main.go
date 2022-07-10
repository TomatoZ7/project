package main

import (
	"./ch6"
	"fmt"
)

func main()  {
	p := ch6.Point{X: 1, Y: 2}
	q := ch6.Point{X: 4, Y: 5}
	fmt.Println(ch6.Distance(p, q))
	fmt.Println(p.Distance(q))
	fmt.Println(q.Distance(p))
}
