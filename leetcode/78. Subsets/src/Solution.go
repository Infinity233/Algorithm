package main

import "sort"

func main() {
	print(subsets([]int{3, 2, 4, 1}))
	print()
}

func subsets(nums []int) [][]int {
	num := 1
	for i := 2; i <= len(nums); i++ {
		num = num*2 + 1
	}

	res := make([][]int, 0, num+1)
	res = append(res, []int{})
	for i := 0; i < len(nums); i++ {
		tlen := len(res)
		for j := 0; j < tlen; j++ {
			t := make([]int, len(res[j]))
			copy(t, res[j])
			t = append(t, nums[i])
			res = append(res, t)
			sort.Ints(res[len(res)-1])
		}
	}

	return res
}
