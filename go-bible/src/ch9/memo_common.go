package ch9

import (
	"io/ioutil"
	"net/http"
)

type Func func(key string) (interface{}, error)

type result struct {
	value interface{}
	err error
}

var urls = []string{
	"https://www.baidu.com",
	"https://www.bilibili.com/",
	"https://www.baidu.com",
}

func httpGetBody(url string) (interface{}, error) {
	resp, err := http.Get(url)
	if err != nil {
		return nil, err
	}
	defer resp.Body.Close()
	return ioutil.ReadAll(resp.Body)
}