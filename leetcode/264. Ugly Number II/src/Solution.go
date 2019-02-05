package main

import "fmt"

func main() {
	fmt.Println(nthUglyNumber(1690))
}

func nthUglyNumber(n int) int {
	res := [1700]int{-1, 1}
	ids := [3]int{1, 1, 1}
	for i := 2; i <= n; i++ {
		a := res[ids[0]] * 2
		b := res[ids[1]] * 3
		c := res[ids[2]] * 5
		m := min(a, b, c)
		res[i] = m
		if m == a {
			ids[0]++
		}
		if m == b {
			ids[1]++
		}
		if m == c {
			ids[2]++
		}
	}
	return res[n]
}

func min(a, b, c int) int {
	if a > b {
		a = b
	}
	if a > c {
		a = c
	}
	return a
}
