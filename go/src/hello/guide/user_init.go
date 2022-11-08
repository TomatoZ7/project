package main

import (
	"fmt"
	trans2 "hello/guide/trans"
)

var twoPi = 2 * trans2.Pi

func main() {
	fmt.Printf("2*Pi = %g\n", twoPi) // 2*Pi = 6.283185307179586
}
