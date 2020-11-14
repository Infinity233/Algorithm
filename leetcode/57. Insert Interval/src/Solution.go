package main

import (
	"fmt"
	"sort"
)

type ById []pair

func (s ById) Len() int           { return len(s) }
func (s ById) Swap(i, j int)      { s[i], s[j] = s[j], s[i] }
func (s ById) Less(i, j int) bool {
	if s[i].v == s[j].v {
		return s[i].lorr < s[j].lorr
	}
	return s[i].v < s[j].v
}

type pair struct {
	v    int
	lorr int
}

func insert(intervals [][]int, newInterval []int) [][]int {

	pairArr := make([]pair, 0, len(intervals))

	for _, v := range intervals {
		pairArr = append(pairArr, pair{
			v:    v[0],
			lorr: 1,
		})
		pairArr = append(pairArr, pair{
			v:    v[1],
			lorr: 2,
		})
	}
	pairArr = append(pairArr, pair{
		v:    newInterval[0],
		lorr: 1,
	})
	pairArr = append(pairArr, pair{
		v:    newInterval[1],
		lorr: 2,
	})

	sort.Sort(ById(pairArr))
	fmt.Println(pairArr)
	res := [][]int{}

	l, counter, r := -1, 0, -1

	for _, pair := range pairArr {

		if pair.lorr == 2 {
			counter--
			r = pair.v
		} else {
			counter++
			if l == -1 {
				l = pair.v
			}
		}

		if counter == 0 && l != -1 && r != -1 {
			res = append(res, []int{l, r})
			l, r = -1, -1
		}
	}

	return res
}

func main() {

	fmt.Println(insert([][]int{{1, 5}}, []int{5, 7}))
}
