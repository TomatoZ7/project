package ch3

import (
	"bytes"
	//"fmt"
)

func Comma(s string) string {
	n := len(s)
	if n <= 3 {
		return s
	}
	return Comma(s[:n-3]) + "," + s[n-3:]
}

func Comma1(s string) string {
	n := len(s)
	if n <= 3 {
		return s
	}
	return s[:3] + "," + Comma1(s[3:])
}

func CommaByBuffer(s string) string {
	var buf bytes.Buffer
	b := []byte(s)
	length := len(b)
	for i := 0; i < length; i++ {
		buf.WriteByte(b[i])
		if (length - i - 1) % 3 == 0 && i + 1 != length {
			buf.WriteByte(',')
		}
	}
	return buf.String()
}
