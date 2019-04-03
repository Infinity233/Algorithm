package main

func searchMatrix(matrix [][]int, target int) bool {

	n := len(matrix)
	if n <= 0 {
		return false
	}
	m := len(matrix[0])
	if m < 0 {
		return false
	}

	for i, j := 0, m-1; i < n && j >= 0; {
		if matrix[i][j] == target {
			return true
		} else if matrix[i][j] > target {
			j--
		} else {
			i++
		}
	}

	return false
}

func main() {

	searchMatrix([][]int{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13)
}
