package ch7

import (
	"fmt"
	"sort"
)

/*
sort.Interface类型也可以适用在其它地方。
编写一个IsPalindrome(s sort.Interface) bool函数表明序列s是否是回文序列，换句话说反向排序不会改变这个序列。
假设如果!s.Less(i, j) && !s.Less(j, i)则索引i和j上的元素相等。
 */

func isPalindrome(s sort.Interface) bool {
	i, j := 0, s.Len()-1
	for j > i {
		if !s.Less(i, j) && !s.Less(j, i) {
			i++
			j--
		} else {
			return false
		}
	}
	return true
}

type pStr string
func (ps pStr) Len() int { return len(ps) }
func (ps pStr) Swap(i, j int) {
	b := []byte(ps)
	b[i], b[j] = b[j], b[i]
	ps = pStr(b)
}
func (ps pStr) Less(i, j int) bool {
	b := []byte(ps)
	return b[i] < b[j]
}

func IsPalindromeRun() {
	ps := pStr("abccva")
	fmt.Println(isPalindrome(ps))
}