package main

import "fmt"

func main() {
	fmt.Print(titleToNumber("ZY"))
}

func titleToNumber(s string) int {
	var ans int32 = 0
	for _, c := range s {
		ans *= 26
		ans += c - 'A' + 1
	}
	return int(ans)
}
