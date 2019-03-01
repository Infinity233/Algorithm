package main

func main() {
	rotate([][]int{{5, 1, 9, 11},
		{2, 4, 8, 10},
		{13, 3, 6, 7},
		{15, 14, 12, 16}})
	rotate([][]int{{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9}})
}

func rotate(matrix [][]int) {
	n, hf := len(matrix), len(matrix)/2
	count := n - 1
	for i := 0; i < hf; i++ {
		t := count

		for j := i; t > 0; t-- {

			x1, y1, x2, y2 := i, j, -1, -1
			for k := 0; k < 3; k++ {
				x2 = n - 1 - y1
				y2 = x1

				tmp := matrix[x1][y1]
				matrix[x1][y1] = matrix[x2][y2]
				matrix[x2][y2] = tmp

				x1 = x2
				y1 = y2
			}
			j++
		}

		count -= 2
	}
}
