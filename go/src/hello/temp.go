// Echo1 prints its command-line arguments.
package main

import "fmt"

func main() {
	printArr([]int{1, 2})
}

func printArr[T int](arr []T) {
	for _, a := range arr {
		fmt.Println(a)
	}
}