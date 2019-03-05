package main

func main() {
	setZeroes([][]int{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}})
}

func setZeroes(matrix [][]int) {
	fr, fc := false, false

	n := len(matrix)
	m := len(matrix[0])
	for i := 0; i < n; i++ {

		for j := 0; j < m; j++ {
			if matrix[i][j] == 0 {
				if i == 0 {
					fr = true
				}
				if j == 0 {
					fc = true
				}
				matrix[0][j] = 0
				matrix[i][0] = 0
			}
		}
	}

	for i := 1; i < n; i++ {
		if matrix[i][0] == 0 {
			for j := 1; j < m; j++ {
				matrix[i][j] = 0
			}
		}
	}
	for i := 1; i < m; i++ {
		if matrix[0][i] == 0 {
			for j := 1; j < n; j++ {
				matrix[j][i] = 0
			}
		}
	}

	if fr {
		for i := 0; i < m; i++ {
			matrix[0][i] = 0
		}
	}
	if fc {
		for i := 0; i < n; i++ {
			matrix[i][0] = 0
		}
	}
	print(465)
}
