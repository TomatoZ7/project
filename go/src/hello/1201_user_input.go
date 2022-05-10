package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	//readInput()
	//readInput2()
	switchInput()
}

func readInput() {
	var (
		firstName, lastName, s string
		i int
		f float32
		input = "56.12 / 5212 / Go"
		format = "%f / %d / %s"
	)

	fmt.Println("Please enter your full name: ")
	_, _ = fmt.Scanln(&firstName, &lastName)
	fmt.Printf("Hi %s %s!\n", firstName, lastName)
	_, _ = fmt.Sscanf(input, format, &f, &i, &s)
	fmt.Println("From the string we read:", f, i, s)
}

func readInput2() {
	inputReader := bufio.NewReader(os.Stdin)
	fmt.Println("Please enter some input: ")
	input, err := inputReader.ReadString('\n')
	if err == nil {
		fmt.Printf("The input was: %s\n", input)
	}
}

func switchInput() {
	inputReader := bufio.NewReader(os.Stdin)
	fmt.Println("Please enter your name:")
	input, err := inputReader.ReadString('\n')

	if err != nil {
		fmt.Println("There were errors reading, exiting program.")
		return
	}

	fmt.Printf("Your name is %s", input)

	//switch input {
	//case "Philip\n":	fmt.Println("Welcome Philip")
	//case "Chris\n":		fmt.Println("Welcome Chris")
	//case "Ivo\n":		fmt.Println("Welcome Ivo")
	//default:			fmt.Printf("You are not welcome here! GoodBye!")
	//}

	//switch input {
	//case "Philip\n":	fallthrough
	//case "Chris\n":		fallthrough
	//case "Ivo\n":		fmt.Printf("Welcome %s\n", input)
	//default:			fmt.Printf("You are not welcome here! GoodBye!")
	//}

	switch input {
	case "Philip\n", "Chris\n":		fmt.Printf("Welcome %s\n", input)
	default:			fmt.Printf("You are not welcome here! GoodBye!")
	}
}
