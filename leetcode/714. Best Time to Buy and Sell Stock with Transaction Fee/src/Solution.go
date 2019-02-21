package main

func main() {

	print(maxProfit([]int{1, 3, 2, 8, 4, 9}, 2))
}

func maxProfit(prices []int, fee int) int {

	l := len(prices)
	if l < 2 {
		return 0
	}
	sold, hold := 0, 0-prices[0]
	var tmp int
	for i := 1; i < l; i++ {
		tmp = sold
		sold = max(sold, hold+prices[i]-fee)
		hold = max(hold, tmp-prices[i])
	}
	return sold
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
