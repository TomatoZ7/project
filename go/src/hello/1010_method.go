package main

import (
	"fmt"
	"time"
)

func main() {
	//method()
	//methodPractice1()
	methodOnAlias()
}

type TwoInts struct {
	a int
	b int
}

func method() {
	two1 := new(TwoInts)
	two1.a = 12
	two1.b = 10

	fmt.Printf("The sum is: %d\n", two1.AddThem())
	fmt.Printf("Add them to the param: %d\n", two1.AddToParam(20))

	two2 := TwoInts{3, 4}
	fmt.Printf("The sum is: %d\n", two2.AddThem())
}

func (tn *TwoInts) AddThem() int {
	return tn.a + tn.b
}

func (tn *TwoInts) AddToParam(param int) int {
	return tn.a + tn.b + param
}

type employee struct {
	salary float32
}

func methodPractice1() {
	em := new(employee)
	em.salary = 10000
	fmt.Printf("The final salary is: %f\n", em.giveRaise(50))
}

func (e *employee) giveRaise(raise float32) float32 {
	return e.salary * (1 + raise / 100)
}

// method on alias
type myTime struct {
	time.Time
}

func (t myTime) first3Chars() string {
	return t.Time.String()[0:3]
}

func methodOnAlias() {
	m := myTime{time.Now()}
	// 调用匿名Time上的String方法
	fmt.Println("Full time now:", m.String())
	// 调用myTime.first3Chars
	fmt.Println("First 3 chars:", m.first3Chars())
}
