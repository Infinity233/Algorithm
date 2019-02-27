package main

func main() {

	print(findJudge(3, [][]int{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}))
}

func findJudge(N int, trust [][]int) int {
	if len(trust) < 1 {
		return -1
	}
	fa := trust[0][1]
	v := make([]int, N+1)
	for i := range trust {
		a := trust[i][0]
		b := trust[i][1]
		if b != fa {
			return -1
		}
		v[a] = b
	}
	flag := 0
	for i, v := range v {
		if flag != 0 && v != fa {
			return -1
		} else if v != fa {
			flag = i
		}
	}
	return flag
}
