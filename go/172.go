package main

import "fmt"

func main() {
	fmt.Print(trailingZeroes(168))
}

func trailingZeroes(n int) int {
	var ans = 0
	var mod = 5
	for mod <= n {
		ans += n / mod
		mod *= 5
	}
	return ans
}
