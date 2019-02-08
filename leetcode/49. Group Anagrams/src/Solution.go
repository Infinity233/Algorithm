package main

import "fmt"

func main() {
	fmt.Println(toSortedStr("asdbsda"))
	println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))

}

func groupAnagrams(strs []string) [][]string {
	strMap := make(map[string][]string)

	for _, str := range strs {
		t := toSortedStr(str)
		if strMap[t] == nil {
			strMap[t] = []string{str}
		} else {
			strMap[t] = append(strMap[t], str)
		}
	}
	res := make([][]string, 0, len(strMap))
	for _, v := range strMap {
		res = append(res, v)
	}
	return res
}

func toSortedStr(str string) string {

	words := [130]int{}
	l := len(str)
	res := ""
	for i := 0; i < l; i++ {
		words[str[i]]++
	}

	for i := 'a'; i <= 'z'; i++ {

		for j := 0; j < words[i]; j++ {
			res = res + string(byte(i))
		}
	}
	return res
}
