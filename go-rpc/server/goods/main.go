package main

import (
	"fmt"
	"net"
	"net/rpc"
)

// 创建远程调用的函数，函数一般是放在结构体里面
type Goods struct{}
// 添加的IO参数
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
// 查询的 IO 参数
type GetGoodsReq struct {
	Id int
}
type GetGoodsRes struct {
	Id int
	Title string `default:"good title"`
	Price float32
	Content string `default:"good content"`
}

func (this Goods) AddGoods(req GetGoodsReq, res *GetGoodsRes) error {
	// 执行增加
	fmt.Println(req)
	// 返回增加的结果
	*res = GetGoodsRes{
		Id: 10,
		Price: 22.4,
	}
	return nil
}

func (this Goods) GetGoods(req GetGoodsReq, res *GetGoodsRes) error {
	// 查询商品
	fmt.Printf("%#v", req)
	// 增加查询结果
	*res = GetGoodsRes{
		Id: 10,
		Price: 32.2,
	}

	return nil
}

func main() {
	// 1.注册 RPC 服务
	err1 := rpc.RegisterName("goods", new(Goods))
	if err1 != nil {
		fmt.Println(err1)
	}

	// 2.监听端口
	listener, err2 := net.Listen("tcp", "127.0.0.1:8020")
	if err2 != nil {
		fmt.Println(err2)
	}
	defer listener.Close()

	// 3.建立连接
	for {
		fmt.Println("connection building...")
		conn, err3 := listener.Accept()
		if err3 != nil {
			fmt.Println(err3)
		}
		rpc.ServeConn(conn)
	}
}