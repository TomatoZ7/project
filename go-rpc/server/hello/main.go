package main

import (
	"fmt"
	"net"
	"net/rpc"
	"net/rpc/jsonrpc"
)

// 定义一个远程调用方法
type Hello struct {
}

/*
1.方法只能有两个可序列化的参数，其中第二个参数是指针类型
req: 表示获取客户端传过来的数据
res: 表示给客户端返回数据
2.方法要返回一个 error 类型，同时必须是公开的方法
3.req 和 res 的类型不能是 channel、complex、func
 */
func (this Hello) SayHello(req string, res *string) error {
	fmt.Println(req)
	*res = "{\"msg\": \"Hello Client\"}"
	return nil
}

func main() {
	// 1.注册 RPC 服务
	err1 := rpc.RegisterName("hello", new(Hello))
	if err1 != nil {
		fmt.Println(err1)
	}

	// 2.监听端口
	listener, err2 := net.Listen("tcp", "192.168.100.255:8088")
	if err2 != nil {
		fmt.Println(err2)
	}
	defer listener.Close()

	for {
		fmt.Println("connection building...")
		// 3.建立连接
		conn, err3 := listener.Accept()
		if err3 != nil {
			fmt.Println(err3)
		}
		// 4.绑定服务
		//rpc.ServeConn(conn)
		rpc.ServeCodec(jsonrpc.NewServerCodec(conn))
	}
}
