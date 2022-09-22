package main

import (
	"fmt"
	"net"
	"net/rpc"
	"net/rpc/jsonrpc"
)

// add
type AddGoodsReq struct {
	Id int
	Title string
	Price float32
	Content string
}
type AddGoodsRes struct {
	Success bool
	Message string
}
// get
type GetGoodsReq struct {
	Id int
}
type GetGoodsRes struct {
	Id int
	Title string `default:"good title"`
	Price float32
	Content string `default:"good content"`
}

func main() {
	// 1.net.Dial 和 rpc 微服务端建立连接
	conn, err1 := net.Dial("tcp", "127.0.0.1:8088")
	if err1 != nil {
		fmt.Println("err1:", err1)
	}
	defer conn.Close()

	// 建立基于 json 编解码服务的 rpc 服务
	client := rpc.NewClientWithCodec(jsonrpc.NewClientCodec(conn))

	// 2.调用远程函数
	var reply GetGoodsRes
	err2 := client.Call("hello.SayHello", "im client", &reply)
	if err2 != nil {
		fmt.Println(err2)
	}

	// 3.打印返回的数据
	fmt.Println(reply)
}