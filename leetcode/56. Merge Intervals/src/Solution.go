package main

import "sort"

type Interval struct {
	Start int
	End   int
}

type Intervals []Interval

func (s Intervals) Len() int {
	return len(s)
}

func (s Intervals) Less(i, j int) bool {
	return s[i].Start < s[j].Start
}

func (s Intervals) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func merge(intervals []Interval) []Interval {
	sort.Sort(Intervals(intervals))
	res := make([]Interval, 0, len(intervals))
	l := len(intervals)
	for i := 0; i < l; i++ {
		start := intervals[i].Start
		end := intervals[i].End
		flag := false
		i++
		for ; i < l; i++ {
			if intervals[i].Start > end {
				res = append(res, Interval{start, end})
				flag = true
				break
			} else {
				if intervals[i].End > end {
					end = intervals[i].End
				}
			}
		}
		i--
		if !flag {
			res = append(res, Interval{start, end})
		}
	}
	return res
}
