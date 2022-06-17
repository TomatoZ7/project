package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
	"strings"
)

func main() {
	for _, url := range os.Args[1:] {
		if !strings.HasPrefix(url, "http://") {
			url = "http://" + url
			fmt.Println(url)
		}
		resp, err := http.Get(url)
		if err != nil {
			_, _ = fmt.Fprintf(os.Stderr, "fetch: %v\n", err)
			os.Exit(0)
		}
		// 打印状态码
		fmt.Println(resp.Status)
		b, err := ioutil.ReadAll(resp.Body)
		_ = resp.Body.Close()
		if err != nil {
			_, _ = fmt.Fprintf(os.Stderr, "fetach: reading %s: %v\n", url, err)
			os.Exit(0)
		}
		fmt.Printf("%s", b)
	}
}
