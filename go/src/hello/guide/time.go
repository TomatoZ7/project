package main

import (
	"fmt"
	"time"
)

func main() {
	//t := time.Now()
	//fmt.Println(t)
	//fmt.Printf("%02d.%02d.%4d\n", t.Day(), t.Month(), t.Year())	// 25.04.2022
	//
	//t = time.Now().UTC()
	//fmt.Println(t)				// 2022-04-25 05:40:41.712586 +0000 UTC
	//fmt.Println(time.Now())		// 2022-04-25 13:40:41.712591 +0800 AWST m=+0.000926626
	//
	//week := 60 * 60 * 24 * 7 * 1e9	// must be in nanosec
	//weekFromNow := t.Add(time.Duration(week))
	//fmt.Println(weekFromNow)

	// 格式化时间
	now := time.Now()
	dateStr := fmt.Sprintf("%d-%d-%d %d:%d:%d", now.Year(), int(now.Month()), now.Day(), now.Hour(), now.Minute(), now.Second())
	fmt.Println(dateStr) // 2022-4-25 13:57:10

	dateStr1 := fmt.Sprintf("%02d-%02d-%02d %02d:%02d:%02d", now.Year(), int(now.Month()), now.Day(), now.Hour(), now.Minute(), now.Second())
	fmt.Println(dateStr1) // 2022-04-25 14:01:27

	//fmt.Println(now.Format("2021/01/24 12:24:02"))
	fmt.Println(now.Format("2006/01/02 15:04:05"))

	fmt.Println(now.Format("2006-01-02 15:04:05"))

	fmt.Println(now.Format("2006-01-02"))

	fmt.Println(now.Format("15:04:05"))
}
