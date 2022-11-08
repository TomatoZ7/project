package main

import (
	sort2 "hello/guide/sort"
)
import "fmt"

func ints() {
	data := []int{74, 59, 238, -784, 9845, 959, 905, 0, 0, 42, 7586, -5467984, 7586}
	// conversion to type IntArray
	a := sort2.IntArray(data)
	sort2.Sort(a)
	if !sort2.IsSorted(a) {
		panic("sort fails")
	}
	fmt.Printf("The sorted array is: %v\n", a)
}

func strings1() {
	data := []string{"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"}
	a := sort2.StringArray(data)
	sort2.Sort(a)
	if !sort2.IsSorted(a) {
		panic("sort fails")
	}
	fmt.Printf("The sorted array is: %v\n", a)
}

type day struct {
	num       int
	shortName string
	longName  string
}

type dayArray struct {
	data []*day
}

func (p *dayArray) Len() int {
	return len(p.data)
}

func (p *dayArray) Less(i, j int) bool {
	return p.data[i].num < p.data[j].num
}

func (p *dayArray) Swap(i, j int) {
	p.data[i], p.data[j] = p.data[j], p.data[i]
}

func days() {
	Sunday := day{0, "SUN", "Sunday"}
	Monday := day{1, "MON", "Monday"}
	Tuesday := day{2, "TUE", "Tuesday"}
	Wednesday := day{3, "WED", "Wednesday"}
	Thursday := day{4, "THU", "Thursday"}
	Friday := day{5, "FRI", "Friday"}
	Saturday := day{6, "SAT", "Saturday"}
	data := []*day{&Tuesday, &Thursday, &Wednesday, &Sunday, &Monday, &Friday, &Saturday}
	a := dayArray{data}
	sort2.Sort(&a)
	if !sort2.IsSorted(&a) {
		panic("sort fails")
	}
	for _, d := range data {
		fmt.Printf("%s ", d.longName)
	}
	fmt.Printf("\n")
}

func main() {
	ints()
	strings1()
	days()
}
