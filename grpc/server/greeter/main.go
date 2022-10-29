package main

import (
	"context"
	"fmt"
	"greeter/proto/ping"
	"net"

	"google.golang.org/grpc"
)

type Hello struct{}

func (h Hello) Ping(c context.Context, req *ping.PingMsg) (*ping.PongMsg, error) {
	return &ping.PongMsg{
		Msg: "pong",
	}, nil
}

func main() {
	// 1.初始 grpc 对象
	grpcServer := grpc.NewServer()
	// 2.注册服务
	ping.RegisterPingServer(grpcServer, &Hello{})
	// 3.设置监听
	listener, err := net.Listen("tcp", "127.0.0.1:8080")
	if err != nil {
		fmt.Println(err)
	}
	defer listener.Close()
	// 4.启动服务
	grpcServer.Serve(listener)
}
