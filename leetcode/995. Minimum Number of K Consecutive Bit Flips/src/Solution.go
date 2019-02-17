package main

func minKBitFlips(A []int, K int) int {

	cur, res := 0, 0
	for i, v := range A {

		if i >= K && A[i-K] == 2 {
			cur--
		}
		if (cur & 1) == v {
			if i+K > len(A) {
				return -1
			}
			A[i] = 2
			cur++
			res++
		}
	}
	return res
}

func main() {

	print(minKBitFlips([]int{1, 1, 0}, 2))
}
