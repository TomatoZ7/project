package main

import (
	"log"
	"net/http"
)

type HandleFnc func(http.ResponseWriter, *http.Request)

func main() {
	http.HandleFunc("/test1", logPanics(SimpleServer))
	http.HandleFunc("/test2", logPanics(FormServer))
	if err := http.ListenAndServe(":8080", nil); err != nil {
		panic(err)
	}
}

func logPanics(function HandleFnc) HandleFnc {
	return func(writer http.ResponseWriter, request *http.Request) {
		defer func() {
			if x := recover(); x != nil {
				log.Printf("[%v] caught panic %v", request.RemoteAddr, x)

				// 给页面一个错误信息，返回 500
				http.Error(writer, http.StatusText(http.StatusInternalServerError), http.StatusInternalServerError)
			}
		}()

		function(writer, request)
	}
}
