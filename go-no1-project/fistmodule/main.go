package main

type Inter interface {
	play()
}

type Stu struct {
	Inter
}

// func (kk Stu) play() {
// 	fmt.Println(kk.cxk + "play basketball")
// }

func main() {
	var i Inter
	i = Stu{}
	println(i)
}
