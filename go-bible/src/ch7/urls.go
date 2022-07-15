package ch7

import (
	"flag"
	"fmt"
	"strings"
)

type urls []string
var isNew bool

func (u *urls) String() string {
	var r []string
	for _, s := range *u {
		r = append(r, fmt.Sprintf("%q", s))
	}
	return strings.Join(r, ", ")
}

func (u *urls) Set(s string) error {
	if !isNew {
		*u = nil
		isNew = true
	}
	*u = append(*u, s)
	return nil
}

func UrlsRun() {
	var value urls
	flag.Var(&value, "url", "链接")
	flag.Parse()
	fmt.Printf("%T %[1]q\n", value)
	s := []string(value)
	fmt.Printf("%T %[1]q\n", s)
}