package ch7

import (
	"fmt"
	"sort"
)

/*
很多图形界面提供了一个有状态的多重排序表格插件：
主要的排序键是最近一次点击过列头的列，
第二个排序键是第二最近点击过列头的列，等等。
定义一个sort.Interface的实现用在这样的表格中。
比较这个实现方式和重复使用sort.Stable来排序的方式。
 */

type multier struct {
	t			[]*Track
	primary 	string
	secondary 	string
	third 		string
}

func (x *multier) Len() int { return len(x.t) }
func (x *multier) Swap(i, j int) { x.t[i], x.t[j] = x.t[j], x.t[i] }

func (x *multier) Less(i, j int) bool {
	key := x.primary
	for k := 0; k < 3; k++ {
		switch key {
		case "Title":
			if x.t[i].Title != x.t[j].Title {
				return x.t[i].Title < x.t[j].Title
			}
		case "Year":
			if x.t[i].Year != x.t[j].Year {
				return x.t[i].Year < x.t[j].Year
			}
		case "Length":
			if x.t[i].Length != x.t[j].Length {
				return x.t[i].Length < x.t[j].Length
			}
		}
		if k == 0 {
			key = x.secondary
		} else if k == 1 {
			key = x.third
		}
	}
	return false
}

//// 更新排序键优先级
//func setPrimary(x *multier, p string) {
//	x.primary, x.secondary, x.third = p, x.primary, x.secondary
//}
//
//// if x is *multiple type, then update ordering keys
//func SetPrimary(x sort.Interface, p string) {
//	if x, ok := x.(*multier); ok {
//		setPrimary(x, p)
//	}
//}

// return a new multier
func NewMultier(t []*Track, p, s, th string) sort.Interface {
	return &multier{
		t: t,
		primary: p,
		secondary: s,
		third: th,
	}
}

// 下面是输出测试
func SortTableRun() {
	printTracks(tracks)

	multier := NewMultier(tracks, "Title", "Year", "Length")
	fmt.Println("\nCustom by Title, Year, Length")
	sort.Sort(multier)
	printTracks(tracks)

	multier = NewMultier(tracks, "Year", "Title", "Length")
	fmt.Println("\nCustom by Year, Title, Length")
	sort.Sort(multier)
	printTracks(tracks)
}