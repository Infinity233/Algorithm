package main

func removeDuplicates(nums []int) int {

	counter := 0
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1] {
			counter++
		} else {
			counter = 0
		}
		if counter >= 2 {
			nums[i-1] ++
		}
	}

	counter = 1
	for i := len(nums) - 1; i > 0; i-- {

		if nums[i] >= nums[i-1] {
			counter++
		} else {
			removeOne(nums, i, counter)
		}
	}
	return counter
}

func removeOne(nums []int, index int, length int) {
	right := index + length

	for i := index; i < right; i++ {
		nums[i-1] = nums[i]
	}
}

func main() {
	println(removeDuplicates([]int{0,0,1,1,1,1,2,3,3}))
}
