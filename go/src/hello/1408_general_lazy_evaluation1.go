package main

import "fmt"

type Any1 interface {}
type EvalFunc func(Any1) (Any1, Any1)

func BuildLazyEvaluator(evalFunc EvalFunc, initState Any1) func() Any1 {
	retValChan := make(chan Any1)
	loopFunc := func() {
		var actState Any1 = initState
		var retVal Any1
		for {
			retVal, actState = evalFunc(actState)
			retValChan <- retVal
		}
	}
	retFunc := func() Any1 {
		return <- retValChan
	}
	go loopFunc()
	return retFunc
}

func BuildLazyIntEvaluator(evalFunc EvalFunc, initState Any1) func() int {
	ef := BuildLazyEvaluator(evalFunc, initState)
	return func() int {
		return ef().(int)
	}
}

func main() {
	evenFunc := func(state Any1) (Any1, Any1) {
		os := state.(int)
		ns := os + 2
		return os, ns
	}

	even := BuildLazyIntEvaluator(evenFunc, 0)

	for i := 0; i < 10; i++ {
		fmt.Printf("%vth even: %v\n", i, even())
	}
}
