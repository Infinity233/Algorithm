package main

func main() {
	println(wordBreak("applepenapple", []string{"apple", "pn", "sand", "and", "cat"}))
}

func wordBreak(s string, wordDict []string) bool {

	l := len(s)
	dp := make([]int, l+1)
	dict := make(map[string]int)
	dp[0] = 1
	for _, v := range wordDict {
		dict[v] = 1
	}
	for i := 1; i <= l; i++ {
		for j := 0; j < i; j++ {
			if dp[j] == 1 && dict[s[j:i]] == 1 {
				dp[i] = 1
				break
			}
		}
	}
	return dp[l] == 1
}
