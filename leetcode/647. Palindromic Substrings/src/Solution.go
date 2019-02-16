package main

func main() {
	println(countSubstrings("abc"))
	println(countSubstrings("aaaa"))
}

func countSubstrings(s string) int {

	ls := len(s)
	dp := make([][]int, ls)
	res := ls
	for i := range dp {
		dp[i] = make([]int, ls)
		dp[i][i] = 1
	}

	for i := 0; i < ls; i++ {

		for j := 0; j < i; j++ {
			if s[i] == s[j] {

				ti, tj := i-1, j+1
				if tj >= ti || dp[tj][ti] == 1 {
					dp[j][i] = 1
					res++
				}
			}
		}
	}

	return res
}

//func countSubstrings(s string) int {
//
//	ans :=0
//	for center:=0; center <= 2*len(s)-1; center++ {
//		left := center / 2
//		right := left + center%2
//		for left >=0 && right < len(s) && s[left] == s[right] {
//			ans++
//			left--
//			right++
//		}
//	}
//	return ans
//}
