package ch7

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

//  实现一个针对单词的计数器。 bufio.ScanWords
type WordCounter int

func (w *WordCounter) Write(p []byte) {
	scanner := bufio.NewScanner(strings.NewReader(string(p)))
	// Set the split function for the scanning operation.
	scanner.Split(bufio.ScanWords)
	for scanner.Scan() {
		*w++
	}
	// err handle
	if err := scanner.Err(); err != nil {
		_, _ = fmt.Fprintln(os.Stderr, "reading input error: ", err)
	}
	// finish
	fmt.Println(*w)
}

func WCRun() {
	var w WordCounter
	w.Write([]byte("test and test"))
}
