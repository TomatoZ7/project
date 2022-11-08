package main

import "fmt"

func main() {
	str2 := "Chinese: 日本語"
	fmt.Println("index int(rune) rune    char bytes")
	for index, rune := range str2 {
		fmt.Printf("%-2d      %d      %U '%c' % X\n", index, rune, rune, rune, []byte(string(rune)))
	}

	//for i := 0; i < 5; i++ {
	//	var v int
	//	fmt.Printf("%d ", v)
	//	v = 5
	//}

	//for i := 0; ; i++ {
	//	fmt.Println("Value of i:", i)
	//}

	//s := ""
	//for ; s != "aaaaa"; {
	//	fmt.Println("Value of s:", s)
	//	s = s + "a"
	//}
}
