package main

import (
	"fmt"
	"math"
)

type Square3 struct {
	side float32
}

type Circle3 struct {
	radius float32
}

type Shaper3 interface {
	Area() float32
}

func (sq *Square3) Area() float32 {
	return sq.side * sq.side
}

func (ci *Circle3) Area() float32 {
	return ci.radius * ci.radius * math.Pi
}

func main() {
	var areaIntf Shaper3
	sq1 := new(Square3)
	sq1.side = 5

	areaIntf = sq1
	if t, ok := areaIntf.(*Square3); ok {
		fmt.Printf("The type of areaIntf is: %T\n", t)
	}

	if u, ok := areaIntf.(*Circle3); ok {
		fmt.Printf("The type of areaIntf is: %T\n", u)
	} else {
		fmt.Println("areaIntf does not contain a variable of type Circle")
	}
}
