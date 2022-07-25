package ch9

import "sync"

type entry struct {
	res result
	ready chan struct{}		// closed when res is ready
}

type Memo4 struct {
	f Func
	mu sync.Mutex
	cache map[string]*entry
}

func New4(f Func) *Memo4 {
	return &Memo4{f: f, cache: make(map[string]*entry)}
}

func (memo *Memo4) Get(key string) (value interface{}, err error) {
	memo.mu.Lock()
	e := memo.cache[key]
	if e == nil {
		e = &entry{ready: make(chan struct{})}
		memo.cache[key] = e
		memo.mu.Unlock()

		e.res.value, e.res.err = memo.f(key)

		close(e.ready)
	} else {
		memo.mu.Unlock()
		<-e.ready
	}

	return e.res.value, e.res.err
}