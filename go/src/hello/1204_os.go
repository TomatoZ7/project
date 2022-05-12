package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	osArgs()
}

func osArgs() {
	who := "Alice "
	if len(os.Args) > 1 {
		who += strings.Join(os.Args[1:], " ")
	}
	fmt.Println("Good Morning", who)
	fmt.Println(os.Args)
}
