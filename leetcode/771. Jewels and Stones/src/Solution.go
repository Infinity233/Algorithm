package main

func numJewelsInStones(J string, S string) int {
	v := [130]bool{}

	for i := 0; i < len(J); i++ {
		v[J[i]] = true
	}
	res := 0

	for i := 0; i < len(S); i++ {
		if v[S[i]] {
			res++
		}
	}
	return res
}
