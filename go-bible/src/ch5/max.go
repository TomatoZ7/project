package ch5

func Max(values... int) int {
	var maxNum int
	for key, val := range values {
		if key == 0 {
			maxNum = val
		}

		if val > maxNum {
			maxNum = val
		}
	}
	return maxNum
}
