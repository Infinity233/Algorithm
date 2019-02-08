package main

func minFallingPathSum(a [][]int) int {

	l := len(a)
	if l < 1 {
		return 0
	}

	dp := [105][105]int{}

	for i := 0; i < l; i++ {
		dp[0][i] = a[0][i]
	}
	for i := 1; i < l; i++ {

		for j := 0; j < l; j++ {
			if j == 0 {
				dp[i][j] = min(dp[i-1][j], dp[i-1][j+1])
			} else if j == l-1 {
				dp[i][j] = min(dp[i-1][j], dp[i-1][j-1])
			} else {
				dp[i][j] = min(dp[i-1][j], dp[i-1][j-1])
				dp[i][j] = min(dp[i][j], dp[i-1][j+1])
			}
			dp[i][j] += a[i][j]
		}
	}
	res := int(^uint(0) >> 1)

	for i := 0; i < l; i++ {

		res = min(res, dp[l-1][i])
	}
	return res
}

func min(x, y int) int {
	if x > y {
		return y
	}
	return x
}
