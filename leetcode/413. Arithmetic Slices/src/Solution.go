package main

import "fmt"

func main() {

	fmt.Println(numberOfArithmeticSlices([]int{1, 2, 3, 8, 9, 10}))
}

func numberOfArithmeticSlices(A []int) int {
	res := 0
	for i := 0; i < len(A); i++ {

		t := judge(A, i)
		if t != -1 {
			l := t - i + 1
			res += cal(l)
			i = t
		}
	}

	return res
}

func cal(l int) int {

	l -= 2
	return (1 + l) * l / 2
}

func judge(a []int, s int) int {

	if s+3 > len(a) {
		return -1
	}
	cha := a[s+1] - a[s]

	for i := s + 1; i < len(a); i++ {

		if a[i]-a[i-1] != cha {
			if i >= s+3 {
				return i - 1
			} else {
				return -1
			}
		}
	}
	return len(a) - 1
}
