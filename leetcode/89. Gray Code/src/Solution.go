package main

func grayCode(n int) []int {
	length := 1 << n
	res := make([]int, 0, length)
	for i := 0; i < length; i++ {

		res = append(res, i^(i>>1))
	}
	return res
}
