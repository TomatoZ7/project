package main

import (
	"./rpc_objects"
	"fmt"
	"log"
	"net/rpc"
)

const serverAddress = "localhost"

func main() {
	client, err := rpc.DialHTTP("tcp", serverAddress + ":1234")
	if err != nil {
		log.Fatal("Error dialing", err)
	}
	// Synchronous call
	args := &rpc_objects.Args{N: 7, M: 8}
	var reply int

	// 同步
	//err = client.Call("Args.Multiply", args, &reply)
	//if err != nil {
	//	log.Fatal("Args error:", err)
	//}
	//fmt.Printf("Args: %d * %d = %d", args.N, args.M, reply)

	// 异步
	i := 1
	call1 := client.Go("Args.Multiply", args, &reply, nil)
	for {
		select {
		case replyCall := <-call1.Done:
			fmt.Printf("%v", replyCall)
			return
		default:
			fmt.Println(i)
			i++
		}
	}
}