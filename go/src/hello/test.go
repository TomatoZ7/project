package main

import (
	"fmt"
	"math"
	"strconv"
)

func main() {
	res, _ := strconv.ParseFloat(fmt.Sprintf("%.6f", math.Sqrt(10)), 64)
	fmt.Println(res)

	fmt.Println(fmt.Sprintf("%.6f", 3.1415926))
	fmt.Println()
}