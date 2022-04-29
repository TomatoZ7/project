package main

import (
	"fmt"
	"os"
	"runtime"
)

func main() {
	type IZ int

	var a IZ = 5
	c := int(a)
	d := IZ(c)
	fmt.Println(c)
	fmt.Println(d)

	x := 5.21
	y := IZ(x)
	fmt.Println(x)
	fmt.Println(y)

	fmt.Println("----------常量----------")
	const Ln2 = 0.693147180559945309417232121458176568075500134360255254120680009
	const Log2E = 1 / Ln2 // this is a precise reciprocal
	const Billion = 1e9   // float constant
	const hardEight = (1 << 100) >> 97
	fmt.Println(Ln2)
	fmt.Println(Log2E)
	fmt.Println(Billion)
	fmt.Println(hardEight)

	const (
		Unknown = 0
		Female  = 1
		Male    = 2
	)
	fmt.Println(Unknown, Female, Male)

	fmt.Println("----------变量----------")
	var strInfo string = "sh"
	fmt.Println(strInfo)

	var goos string = runtime.GOOS
	fmt.Printf("The operating system is: %s\n", goos)
	path := os.Getenv("PATH")
	fmt.Printf("Path is %s\n", path)
}
