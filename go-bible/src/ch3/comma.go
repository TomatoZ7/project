package ch3

import "bytes"

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
	for i := length-1; i >= 0; {
		buf.Write(b[i-3:])
		i -= 3
		if i < 0 {

		}
	}
	return buf.String()
}
