package main

import "fmt"

func main() {
	genByteSliceByString()
}

func genByteSliceByString() {
	s := "\u00ff\u754c"
	for i, c := range s {
		fmt.Printf("%d:%c", i, c)
	}

	var b []byte
	var x string = "anc"
	b = append(b, x...)
	fmt.Println(b)
}
