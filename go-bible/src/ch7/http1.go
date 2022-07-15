package ch7

/*
下面这个程序可能是能想到的最简单的实现了。
它将库存清单模型化为一个命名为database的map类型，我们给这个类型一个ServeHttp方法，这样它可以满足http.Handler接口。
这个handler会遍历整个map并输出物品信息。
*/

import (
	"fmt"
	"log"
	"net/http"
)

type dollar float64
type database map[string]dollar

func (d dollar) String() { fmt.Printf("%.2f", d) }

func (db database) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	for item, price := range db {
		fmt.Fprintf(w, "%s: %v\n", item, price)
	}
}

func Http1Run() {
	db := database{"shoes": 50, "socks": 5}
	log.Fatal(http.ListenAndServe("localhost:8888", db))
}
