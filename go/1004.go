package main

import "fmt"

func main() {
	var A = []int{0}
	fmt.Print(longestOnes(A, 0))
}
func longestOnes(A []int, K int) int {
	var leftPtr = 0
	var rightPtr = 0
	var max = 0
	var zero = 0
	for rightPtr < len(A) {
		zero += 1 - A[rightPtr]
		for zero > K {
			for A[leftPtr] == 1 {
				leftPtr++
			}
			leftPtr++
			zero--
		}
		if rightPtr-leftPtr+1 > max {
			max = rightPtr - leftPtr + 1
		}
		rightPtr++
	}
	return max
}
