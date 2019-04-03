package main

func main() {
	numSquares(12)
}

func numSquares(n int) int {

	dp := make([]int, n+1)
	for i := range dp {
		dp[i] = 0x3f3f3f
	}
	dp[0] = 0

	for i := 1; i <= n; i++ {
		for j := 1; j*j <= i; j++ {
			dp[i] = min(dp[i], dp[i-j*j]+1)
		}
	}

	return dp[n]
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
