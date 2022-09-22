package main

import (
	"fmt"
	"go-protobuf/proto/userService"
	"google.golang.org/protobuf/proto"
)

func main() {
	fmt.Println("asd")

	u := &userService.Userinfo{
		Username: "rick",
		Age: 20,
		Hobby: []string{"eat", "sleep"},
	}
	fmt.Println(u)

	// 序列化
	data, _ := proto.Marshal(u)
	fmt.Println(data)

	// 反序列化
	var user userService.Userinfo
	proto.Unmarshal(data, &user)
	fmt.Printf("%#v", user)
}
