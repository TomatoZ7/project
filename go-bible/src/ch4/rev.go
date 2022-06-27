package ch4

func Reserve(s []int) {
	for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
}

func ReverseByArr(arr *[5]int) {
	for i, j := 0, len(arr)-1; i < j; i, j = i+1, j-1 {
		arr[i], arr[j] = arr[j], arr[i]
	}
}

// 通过1次循环旋转
func RotateByCycle(s []int, times int) []int {
	tmp := len(s)-times
	for i := 0; i < tmp; i++ {
		s = append(s, s[i])
	}
	return s[tmp:]
}

func RotateByCycleRotate(s []int, times int) []int {
	res := s[len(s)-times:]
	res = append(res, s[:len(s)-times]...)
	return res
}