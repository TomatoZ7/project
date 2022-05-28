package main
//
//import (
//	"fmt"
//	"strings"
//)
//
//func main() {
//	//person()
//	structPractice1()
//}
//
//type struct1 struct {
//	i1 int
//	f1 float32
//	str string
//}
//
//func structsFields() {
//	ms := new(struct1)
//	ms.i1 = 10
//	ms.f1 = 15.5
//	ms.str = "Chris"
//
//	fmt.Printf("The int is: %d\n", ms.i1)
//	fmt.Printf("The float is: %f\n", ms.f1)
//	fmt.Printf("The string is: %s\n", ms.str)
//	fmt.Println(ms)
//}
//
//type Person struct {
//	firstName string
//	lastName string
//}
//
//func upPerson(p *Person) {
//	p.firstName = strings.ToUpper(p.firstName)
//	p.lastName = strings.ToUpper(p.lastName)
//}
//
//func person() {
//	// 1-struct as a value type
//	var pers1 Person
//	pers1.firstName = "Chris"
//	pers1.lastName = "Woodward"
//	upPerson(&pers1)
//	fmt.Printf("The name of the person is %s %s\n", pers1.firstName, pers1.lastName)
//
//	// 2-struct as a pointer
//	pers2 := new(Person)
//	pers2.firstName = "Chris"
//	pers2.lastName = "Woodward"
//	(*pers2).lastName = "woodward"
//	upPerson(pers2)
//	fmt.Printf("The name of the person is %s %s\n", pers2.firstName, pers2.lastName)
//
//	// 3-struct as a literal
//	pers3 := &Person{"Chris", "Woodward"}
//	upPerson(pers3)
//	fmt.Printf("The name of the person is %s %s\n", pers3.firstName, pers3.lastName)
//}
//
//func structPractice1() {
//	type Address struct {
//		addr string
//	}
//
//	type VCard struct {
//		name string
//		age int
//		address *Address
//	}
//
//	var address Address
//	address.addr = "China"
//
//	var Tz VCard
//	Tz.address = &address
//	Tz.name = "tomato z"
//	Tz.age = 19
//
//	fmt.Println(Tz)
//	fmt.Println(*Tz.address)
//	fmt.Printf("address is %s", Tz.address.addr)
//}
