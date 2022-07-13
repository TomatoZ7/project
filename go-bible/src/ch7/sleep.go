package ch7

import (
	"flag"
	"fmt"
	"time"
)

var period = flag.Duration("period", 1*time.Second, "sleep period")

func SleepRun() {
	flag.Parse()
	fmt.Printf("Sleeping for %v...", period)
	time.Sleep(*period)
	fmt.Println()
}
