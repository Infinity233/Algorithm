package main

func trap(height []int) int {

	res, l, r := 0, 0, len(height)-1

	for l < r {
		var min int
		if height[l] < height[r] {
			min = height[l]
		} else {
			min = height[r]
		}

		if min == height[l] {
			l++
			for l<r && height[l] < min {
				res += min - height[l]
				l++
			}
		} else {
			r--
			for l<r && height[r] < min {
				res += min - height[r]
				r--
			}
		}
	}

	return res
}

func main() {

	print(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
	print(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}
