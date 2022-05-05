package main

import (
	"fmt"
	"reflect"
)

func main() {
	//var x float64 = 3.4
	//fmt.Println(reflect.TypeOf(x))
	//fmt.Println(reflect.ValueOf(x))
	//
	//v := reflect.ValueOf(x)
	//fmt.Println(v.Kind())
	//fmt.Println(v.Kind() == reflect.Float64)

	//type MyInt int
	//var m MyInt = 5
	//v := reflect.ValueOf(m)
	//fmt.Println(v)
	//fmt.Println(v.Kind())
	//fmt.Println(v.Interface())

	reflect1()
}

func reflect1() {
	var x float64 = 3.4
	fmt.Println("type:", reflect.TypeOf(x))
	v := reflect.ValueOf(x)
	fmt.Println("value:", v)
	fmt.Println("type:", v.Type())
	fmt.Println("kind:", v.Kind())
	fmt.Println("value:", v.Float())
	// Interface() 方法可以得到还原（接口）值
	fmt.Println(v.Interface())
	fmt.Printf("value is %5.2e\n", v.Interface())
	y := v.Interface().(float64)
	fmt.Println(y)

	fmt.Println(v.CanSet())
	a := reflect.ValueOf(&x)
	fmt.Println(a)
	fmt.Println(a.CanSet())
	a = a.Elem()
	fmt.Println(a.CanSet())
}
