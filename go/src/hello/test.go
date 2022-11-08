package main

import (
	"fmt"
)

func main() {
	s := "(1+(4+5+2)-3)+(6+8)"

	//for i := 0; i < len(s); i++ {
	//	fmt.Println(strconv.Atoi(string(s[i])))
	//	//fmt.Printf("%T - %v\n", s[i], s[i])
	//}

	fmt.Println(s[0:1])

	/*
		-
		(		2
		-		1
		符号栈	数字栈
	 */
}
