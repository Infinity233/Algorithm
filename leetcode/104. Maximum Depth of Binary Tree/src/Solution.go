package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var res = 0

func maxDepth(root *TreeNode) int {
	bianli(root, 1)
	return res
}

func bianli(root *TreeNode, deep int) {

	if root == nil {
		return
	}
	if deep > res {
		res = deep
	}

	bianli(root.Left, deep+1)
	bianli(root.Right, deep+1)
}

func main() {

	root := TreeNode{3, nil, nil}

	fmt.Println(maxDepth(&root))
}
