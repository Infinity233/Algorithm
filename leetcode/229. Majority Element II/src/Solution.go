package main

func main() {
	majorityElement([]int{1, 2, 2, 3, 2, 1, 1, 3})
}

func majorityElement(nums []int) []int {
	c1, c2 := 0, 0
	n1, n2 := 0, 0
	for _, v := range nums {
		if v == n1 {
			c1++
		} else if v == n2 {
			c2++
		} else if c1 == 0 {
			c1++
			n1 = v
		} else if c2 == 0 {
			c2++
			n2 = v
		} else {
			c1--
			c2--
		}
	}
	c1 = 0
	c2 = 0
	for _, v := range nums {
		if v == n1 {
			c1++
		} else if v == n2 {
			c2++
		}
	}
	res := make([]int, 0, 2)
	if c1 > len(nums)/3 {
		res = append(res, n1)
	}
	if c2 > len(nums)/3 {
		res = append(res, n2)
	}
	return res
}
