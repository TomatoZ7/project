package main

import (
	"crypto/sha1"
	"fmt"
	"io"
	"log"
)

func main() {
	hashSha1()
}

func hashSha1() {
	hasher := sha1.New()
	_, _ = io.WriteString(hasher, "test")
	var b []byte
	fmt.Printf("Result: %x\n", hasher.Sum(b))
	fmt.Printf("Result: %d\n", hasher.Sum(b))

	//
	hasher.Reset()
	data := []byte("we shall overcome")
	n, err := hasher.Write(data)
	if err != nil {
		log.Printf("Hash write error: %v / %v", n, err)
	}
	checkSum := hasher.Sum(data)
	fmt.Printf("Result: %x\n", checkSum)
}
