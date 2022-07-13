package ch7

import (
	"flag"
	"fmt"
	"strings"
)

func FlagRun() {
	var upper bool
	flag.BoolVar(&upper, "upper", false, "是否大写")
	flag.Parse()
	for _, arg := range flag.Args() {
		if upper {
			fmt.Println(strings.ToUpper(arg))
		} else {
			fmt.Println(arg)
		}
	}
}