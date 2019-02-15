package main

func main() {

	println(maxProduct([]int{2, 3, -2, 4}))
}

func maxProduct(nums []int) int {
	res, maxn, minn := nums[0], nums[0], nums[0]
	l := len(nums)
	for i := 1; i < l; i++ {

		t1 := maxn * nums[i]
		t2 := minn * nums[i]

		maxn = max(max(t1, t2), nums[i])
		minn = min(min(t1, t2), nums[i])
		res = max(res, maxn)
	}
	return res
}

func max(x, y int) int {

	if x > y {
		return x
	}
	return y
}

func min(x, y int) int {
	if x > y {
		return y
	}
	return x
}
