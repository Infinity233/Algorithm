package main

import (
	"fmt"
	"sort"
	"strings"
)

func main() {
	var array = [10]byte{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'}
	as := array[0:5]
	bs := array[0:5]
	as[0] = 'A'
	fmt.Println(as)
	fmt.Println(bs)
}

func isPalindrome(s string) bool {

	s = strings.ToLower(s)
	s = strings.Map(g, s)
	i, j := 0, len(s)-1
	if j < 1 {
		return true
	}
	for {

		if s[i] != s[j] {
			return false
		}
		i++
		j--
		if i > j {
			break
		}
	}
	return true
}

func g(r rune) rune {
	if (r >= 'a' && r <= 'z') || (r >= '0' && r <= '9') {
		return r
	}
	return -1
}
