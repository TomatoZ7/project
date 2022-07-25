package ch9

import (
	"fmt"
	"log"
	"time"
)

type Memo struct {
	f Func
	cache map[string]result
}

func New(f Func) *Memo {
	return &Memo{f: f, cache: make(map[string]result)}
}

func (memo *Memo) Get(key string) (interface{}, error) {
	res, ok := memo.cache[key]
	if !ok {
		res.value, res.err = memo.f(key)
		memo.cache[key] = res
	}
	return res.value, res.err
}

func Memo1Run() {
	m := New(httpGetBody)
	for _, url := range urls {
		start := time.Now()
		value, err := m.Get(url)
		if err != nil {
			log.Print(err)
		}
		fmt.Printf("%s %s %d bytes\n", url, time.Since(start), len(value.([]byte)))
	}
}