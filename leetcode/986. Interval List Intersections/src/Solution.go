package main

import "fmt"

type Interval struct {
	Start int
	End   int
}

func main() {
	res := intervalIntersection([]Interval{{4, 11}}, []Interval{{1, 2}, {8, 11}, {12, 13}, {14, 15}, {17, 19}})
	fmt.Println(res)
}

func intervalIntersection(a []Interval, b []Interval) []Interval {
	res := make([]Interval, 0)
	lena, lenb := len(a), len(b)

	for i, j := 0, 0; i < lena && j < lenb; {
		if a[i].End < b[j].Start {
			i++
		} else if b[j].End < a[i].Start {
			j++
		} else {
			res = append(res, Interval{max(a[i].Start, b[j].Start), min(a[i].End, b[j].End)})
			if a[i].End < b[j].End {
				i++
			} else {
				j++
			}
		}
	}
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
