package ch7

import (
	"flag"
	"fmt"
	"os"
)

var name string
var age int

func init() {
	flag.CommandLine = flag.NewFlagSet("", flag.ExitOnError)
	flag.StringVar(&name, "name", "Adam", "名字")
	age = *flag.Int("age", 18, "年龄")
	// 和上面两句效果一样
	// flag.CommandLine.StringVar(&name, "name", "Adam", "名字")
	// var ageP = flag.CommandLine.Int("age", 18, "年龄")
	flag.Usage = func() {
		fmt.Fprintln(os.Stderr, "请指定名字和年龄：")
		flag.PrintDefaults()
	}
}

func CURun() {
	flag.Parse()
	fmt.Printf("%T %[1]v\n", name)
	fmt.Printf("%T %[1]v\n", age)
}