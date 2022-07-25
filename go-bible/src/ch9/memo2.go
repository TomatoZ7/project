package ch9

import "sync"

type Memo2 struct {
	f Func
	mu sync.Mutex
	cache map[string]result
}

func (memo *Memo2) Get(key string) (value interface{}, err error) {
	memo.mu.Lock()
	defer memo.mu.Unlock()
	res, ok := memo.cache[key]
	if !ok {
		res.value, res.err = memo.f(key)
		memo.cache[key] = res
	}
	return res.value, res.err
}