package ch4

func appendInt(x []int, y int) []int {
	var z []int
	zlen := len(x) + 1
	if zlen <= cap(x) {
		z = x[:zlen]
	} else {
		zcap := zlen
		if zcap <= len(x) * 2 {
			zcap = len(x) * 2
		}
		z = make([]int, zlen, zcap)
		copy(z, x)
	}

	z[len(x)] = y
	return z
}
