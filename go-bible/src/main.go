package main

import (
	_ "./ch11/word2"
	"fmt"
	"time"
	"unicode"
)

func main() {
	fmt.Println(time.Now().UTC())
	fmt.Println(unicode.ToLower('é'))
	fmt.Println(unicode.ToLower('E'))
}