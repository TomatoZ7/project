// Echo1 prints its command-line arguments.
package main

import (
	"fmt"
	"os"
	"strings"
	"time"
)

func main() {
	input := os.Args
	joint(input)
	stringJoin(input)
}

func joint(param []string) {
	start := time.Now()
	var s, sep string
	for i := 1; i < len(param); i++ {
		s += sep + os.Args[i]
		sep = " "
	}
	fmt.Println(s)
	cost := time.Since(start)
	fmt.Println(cost)
}

func stringJoin(param []string) {
	start := time.Now()
	res := strings.Join(param, "")
	fmt.Println(res)
	cost := time.Since(start)
	fmt.Println(cost)
}