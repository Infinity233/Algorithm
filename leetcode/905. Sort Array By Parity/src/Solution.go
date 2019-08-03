package main

func sortArrayByParity(A []int) []int {

	index := 0
	for i:=0; i<len(A); i++ {
		if ((A[i] & 1) == 0) {
			A[index], A[i] = A[i], A[index]
			index++
		}
	}
	return A
}
