package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {

	res := [][]int{}
	res = bianli(root, 0, res)

	for i := 1; i < len(res); i += 2 {

		l, r := 0, len(res[i])-1

		for l < r {
			res[i][l], res[i][r] = res[i][r], res[i][l]
			l++
			r--
		}
	}
	return res
}

func bianli(node *TreeNode, level int, res [][]int) [][]int {
	if node == nil {
		return res
	}

	if len(res) < level+1 {
		res = append(res, []int{})
	}
	res[level] = append(res[level], node.Val)

	res = bianli(node.Left, level+1, res)
	res = bianli(node.Right, level+1, res)

	return res
}

func main() {
	res := [][]int{}
	fmt.Println(res[12])
}
