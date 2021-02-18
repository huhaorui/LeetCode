package main

import "fmt"

func main() {
	fmt.Print(isPowerOfTwo(0))
}
func isPowerOfTwo(n int) bool {
	if n == 0 {
		return false
	}
	return n&(n-1) == 0
}
