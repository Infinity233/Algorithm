package main

import "fmt"

func numDecodings(s string) int {
	l := len(s)
	if l < 1 || s == "0" {
		return 0
	}
	dp := make([]int, l+1)
	if s[0] == '0' {
		return 0
	}
	dp[0] = 1
	dp[1] = 1

	for i := 2; i <= l; i++ {

		pc := s[i-2]
		nc := s[i-1]

		if nc == '0' {
			if pc <= '2' && pc > '0' {
				dp[i] = dp[i-2]
			} else {
				return 0
			}
		} else if pc == '0' {
			dp[i] = dp[i-1]
		} else {

			if pc == '1' || (pc == '2' && nc <= '6') {
				dp[i] = dp[i-1] + dp[i-2]
			} else {
				dp[i] = dp[i-1]
			}
		}
	}

	return dp[l]
}

func main() {
	fmt.Println(numDecodings("121"))
}
