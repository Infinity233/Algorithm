package main

func moveZeroes(nums []int) {

	index := 0
	for i := 0; i < len(nums); i++ {

		if nums[i] != 0 {
			nums[i], nums[index] = nums[index], nums[i]
			index++
		}
	}
}
