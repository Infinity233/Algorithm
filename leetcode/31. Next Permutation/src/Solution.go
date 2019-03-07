package main

import "fmt"

func main() {
	nums := []int{3, 1}
	nextPermutation(nums)
	for _, v := range nums {
		fmt.Println(v)
	}
}

func nextPermutation(nums []int) {

	numLen := len(nums)
	left := -1
	i := -1
	for i = numLen - 1; i > 0; i-- {
		if nums[i] > nums[i-1] {
			left = i - 1
			break
		}
	}
	if i <= 0 {
		re(nums, 0, numLen-1)
		return
	}
	for i = numLen - 1; i > left; i-- {
		if nums[i] > nums[left] {
			nums[i], nums[left] = nums[left], nums[i]
			break
		}
	}
	re(nums, left+1, numLen-1)
	print()
}

func re(nums []int, left, right int) {
	for i, j := left, right; i < j; {

		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}
