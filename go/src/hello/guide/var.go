package main

var a string

func main() {
	a = "G"
	print(a)
	m()
}

func n() {
	print(a)
}

func m() {
	a := "0"
	print(a)
	n()
}
