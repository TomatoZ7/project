package ch7

import (
	"flag"
	"fmt"
	"strings"
)

type fullName []string

func (v *fullName) String() string {
	var r []string
	for _, s := range *v {
		r = append(r, fmt.Sprintf("%q", s))
	}
	return strings.Join(r, " ")
}

func (v *fullName) Set(s string) error {
	*v = nil
	// strings.Field 可以区分连续的空间
	for _, str := range strings.Fields(s) {
		*v = append(*v, str)
	}
	return nil
}

func FullName(name string, value []string, usage string) *[]string {
	p := new([]string)	// value 是传值近来，取不到地址，new 一个内存空间，存放 value 的值
	*p = value
	flag.CommandLine.Var((*fullName)(p), name, usage)
	return p
}

func SSRun() {
	s := FullName("name", []string{"Jordan", "Kobe"}, "名字")
	flag.Parse()
	fmt.Printf("%q\n", *s)
}