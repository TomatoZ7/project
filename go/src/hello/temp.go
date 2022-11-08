// Echo1 prints its command-line arguments.
package main

import (
	"fmt"
	"strconv"
)

func main() {
	res := calculate("(1+(4+5+2)-3)+(6+8)")
	fmt.Println(res)
}

func calculate(s string) int {
	lenS := len(s)
	res := 0
	// 当前的运算符号
	sign := 1
	// 声明栈
	var opStack []uint8
	var numStack []int

	for i := 0; i < lenS; i++ {
		v := s[i]
		if v == ' ' {
			continue
		} else if v == '+' || v == '-' || v == '(' {
			opStack = append(opStack, v)
		} else if v == ')' {
			var val int
			lenOp := len(opStack)
			lenNum := len(numStack)

			for ; lenOp > 0; lenOp-- {
				peekOp := opStack[lenOp-1]

				if peekOp == '-' {
					val -= numStack[lenNum-1]
				} else {
					val += numStack[lenNum-1]
				}
				lenNum--

				if peekOp == '(' {
					break
				}
			}

			fmt.Println(numStack)
			fmt.Println(opStack)

			opStack = opStack[:lenOp-1]
			numStack = numStack[:lenNum]
			numStack = append(numStack, val)

			fmt.Println(numStack)
			fmt.Println(opStack)
			fmt.Println("----------")

		} else {
			// 整数识别
			var val int
			for i < lenS && 48 <= s[i] && s[i] <= 57 {
				num, _ := strconv.Atoi(string(s[i]))
				val = val * 10 + num
				i++
			}

			// 连同符号入栈
			sign := 1
			opLen := len(opStack)
			if opLen > 0 {
				op := opStack[opLen-1]
				if op == '+' {
					sign = 1
					opStack = opStack[:opLen-1]
				} else if op == '-' {
					sign = -1
					opStack = opStack[:opLen-1]
				}
			}

			numStack = append(numStack, sign * val)
			i--
		}
 	}

	lenOp := len(opStack)
	lenNum := len(numStack)

	for ; lenNum > 0; lenNum-- {
		if lenOp > 0 {
			peekOp := opStack[lenOp-1]

			if peekOp == '-' {
				res -= numStack[lenNum-1]
			} else {
				res += numStack[lenNum-1]
			}
			lenOp--
		} else {
			res += numStack[lenNum-1]
		}
	}

	return res
}