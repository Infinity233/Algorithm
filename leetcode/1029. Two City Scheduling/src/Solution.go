package main

import "sort"

type peoples [][]int

func (p peoples) Len() int {
	return len(p)
}

func (p peoples) Less(i, j int) bool {
	a, b := p[i][0]-p[i][1], p[j][0]-p[j][1]
	return a < b
}

func (p peoples) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

func twoCitySchedCost(costs [][]int) int {

	p, res := peoples(costs), 0
	n := p.Len() / 2
	sort.Sort(p)

	for i := 0; i < n; i++ {
		res += p[i][0]
	}
	for i := n; i < p.Len(); i++ {
		res += p[i][1]
	}

	return res
}

func main() {

	print(twoCitySchedCost([][]int{{10, 20}, {30, 200}, {400, 50}, {30, 20}}))
}
