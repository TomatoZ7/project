package ch3

import "bytes"

func Form(str1, str2 string) bool {
	b1 := []byte(str1)
	b2 := []byte(str2)
	for i, b1Len := 0, len(b1); i < b1Len; i++ {
		for j, b2Len := 0, len(b2); j < b2Len; j++ {
			if b1[i] == b2[j] {
				b1[i] = ' '
				b2[j] = ' '
				break
			}
		}
	}

	if bytes.Contains(b1, b2) {
		return true
	}

	return false
}