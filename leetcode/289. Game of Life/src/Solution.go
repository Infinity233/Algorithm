package main

var fang = [8][2]int{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}
var m int
var n int

func gameOfLife(board [][]int) {
	m = len(board)
	n = len(board[0])

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			board[i][j] = cal(board, i, j)
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			board[i][j] >>= 1
		}
	}
}

func cal(b [][]int, x, y int) int {
	count := 0
	for i := 0; i < 8; i++ {
		if judge(b, x+fang[i][0], y+fang[i][1]) {
			count++
		}
	}

	if b[x][y] == 1 {
		if count < 2 || count > 3 {
			return 1
		} else {
			return 3
		}
	} else {
		if count == 3 {
			return 2
		}
	}
	return 0
}

func judge(b [][]int, x, y int) bool {

	return x >= 0 && x < m && y >= 0 && y < n && (b[x][y] == 1 || b[x][y] == 3)
}
