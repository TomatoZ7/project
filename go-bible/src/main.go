package main

import "fmt"
import "./ch3"

func main()  {
	fmt.Println("abc"[1:2])
	//fmt.Println(ch3.Basename1("/a/b/c.jpg"))
	//fmt.Println(ch3.Basename2("/a/b/c.jpg"))
	fmt.Println(ch3.Form("peter", "repetr"))

}