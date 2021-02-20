package main

import (
	"fmt"
	"math"
)

func main() {
	var nums = []int{1, 2, 3, 1, 1, 3}
	fmt.Print(findShortestSubArray(nums))
}
func maxValue(num map[int]int) int {
	var max = math.MinInt32
	for _, n := range num {
		if n > max {
			max = n
		}
	}
	return max
}
func findShortestSubArray(nums []int) int {
	var appear = make(map[int]int)
	for i := range nums {
		_, isMapContainsKey := appear[nums[i]]
		if isMapContainsKey {
			appear[nums[i]]++
		} else {
			appear[nums[i]] = 1
		}
	}
	var max = 0
	for _, t := range appear {
		if t > max {
			max = t
		}
	}
	var num = make(map[int]int)
	var leftPtr = 0
	var rightPtr = -1
	for maxValue(num) < max {
		rightPtr++
		_, isMapContainsKey := num[nums[rightPtr]]
		if isMapContainsKey {
			num[nums[rightPtr]]++
		} else {
			num[nums[rightPtr]] = 1
		}
	}
	var ans = rightPtr - leftPtr + 1
	for rightPtr < len(nums) {
		num[nums[leftPtr]]--
		leftPtr++
		for maxValue(num) < max && rightPtr < len(nums) {
			rightPtr++
			if rightPtr == len(nums) {
				break
			}
			_, isMapContainsKey := num[nums[rightPtr]]
			if isMapContainsKey {
				num[nums[rightPtr]]++
			} else {
				num[nums[rightPtr]] = 1
			}
		}
		if rightPtr-leftPtr+1 < ans {
			ans = rightPtr - leftPtr + 1
		}
	}
	return ans
}
