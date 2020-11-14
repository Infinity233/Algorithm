package main

func search(nums []int, target int) bool {

	l, r := 0, len(nums)-1

	for l <= r {

		m := (l + r) / 2

		if target == nums[m] {
			return true
		}
		if nums[l] < nums[m] || nums[r] < nums[m] {
			if target < nums[m] && target >= nums[l] {
				r = m - 1
			} else {
				l = m + 1
			}
		} else if nums[l] > nums[m] || nums[r] > nums[m] {
			if target > nums[m] && target <= nums[r] {
				l = m + 1
			} else {
				r = m - 1
			}
		} else {
			r--
		}

	}

	return false
}

func main() {
	print(search([]int{1, 1, 3, 1}, 3))
}
