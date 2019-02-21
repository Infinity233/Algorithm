package main

import "sort"

func main() {
	print(canPartition([]int{6, 2, 3, 5}))
}

func canPartition(nums []int) bool {
	var sum int
	for _, n := range nums {
		sum += n
	}
	if sum%2 != 0 {
		return false
	}
	target := sum / 2
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))
	return recursive(target, nums)
}

func recursive(target int, nums []int) bool {
	if target == 0 {
		return true
	}
	if len(nums) == 0 {
		return false
	}
	if nums[0] > target {
		return false
	}
	for i, n := range nums {
		if recursive(target-n, nums[i+1:]) {
			return true
		}
	}
	return false
}
