package main

func main() {
	print(countPrimes(9))
}

func countPrimes(n int) int {
	if n <= 2 {
		return 0
	}

	prime := make([]int, n+1)
	vis := make([]bool, n+1)
	cnt := 0

	for i := 2; i < n; i++ {

		if !vis[i] {
			prime[cnt] = i
			cnt++
		}
		for j := 0; j < cnt && i*prime[j] < n; j++ {
			vis[i*prime[j]] = true
			if i%prime[j] == 0 {
				break
			}
		}
	}
	return cnt
}
