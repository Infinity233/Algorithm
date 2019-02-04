package main

import "fmt"

func convertToTitle(n int) string {

	res := ""
	for n != 0 {
		n--
		res = string(rune(n%26)+'A') + res
		n /= 26
	}
	return res
}

func main() {
	fmt.Println(convertToTitle(701))

}
