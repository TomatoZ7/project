package ch7

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

type lineCounter int

func (l *lineCounter) Write(p []byte) {
	scanner := bufio.NewScanner(strings.NewReader(string(p)))
	// Set the split function for the scanning operation.
	scanner.Split(bufio.ScanLines)
	for scanner.Scan() {
		*l++
	}
	// err handle
	if err := scanner.Err(); err != nil {
		_, _ = fmt.Fprintln(os.Stderr, "reading input error: ", err)
	}
	// finish
	fmt.Println(*l)
}

func LCRun() {
	var l lineCounter
	l.Write([]byte("Spicy jalapeno pastrami ut ham turducken.\n Lorem sed ullamco, leberkas sint short loin strip steak ut shoulder shankle porchetta venison prosciutto turducken swine.\n Deserunt kevin frankfurter tongue aliqua incididunt tri-tip shank nostrud.\nyou are the world."))
}
