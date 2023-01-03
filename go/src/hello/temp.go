package main

import (
	"fmt"
)

type Pet interface {
	Name() string
	Category() string
}

type Dog struct {
	name string // 名字。
}

func (dog *Dog) SetName(name string) {
	dog.name = name
}

func (dog Dog) Name() string {
	return dog.name
}

func (dog Dog) Category() string {
	return "dog"
}

func main() {
	defer fmt.Println("x")
	defer fmt.Println("y")
	defer fmt.Println("z")
	fmt.Println("q")
}

func modify(param [3][]string) [3][]string {
	//param[0] = []string{"x", "y", "z"}
	param[0][1] = "xxx"
	return param
}