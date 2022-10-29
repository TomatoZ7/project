package main

import (
	"client/proto/ping"
	"context"
	"fmt"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

func main() {
	// 连接服务器
	grpcClient, err := grpc.Dial("127.0.0.1:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		fmt.Println(err)
	}
	// 注册客户端
	client := ping.NewPingClient(grpcClient)

	res, err := client.Ping(context.Background(), &ping.PingMsg{
		Msg: "Ping",
	})
	if err != nil {
		fmt.Println(err)
	}
	fmt.Printf("%#v", res.Msg)
}
