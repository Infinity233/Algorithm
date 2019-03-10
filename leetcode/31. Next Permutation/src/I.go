package main

import (
	"fmt"
	"sort"
)

func main() {
	var n, q int
	a := make([]int, n)
	fmt.Scan(&n, &q)
	fmt.Scan(&a[0])
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	sort.Ints(a)
	for i := 0; i < n; i++ {
		fmt.Print(a[i])
	}
}
