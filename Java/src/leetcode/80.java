package leetcode;

import java.util.Arrays;

class Solution_80 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(new Solution_80().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int leftPtr = 0, rightPtr = 0, length = nums.length;
        while (rightPtr + 1 < length) {
            while (rightPtr < length && nums[rightPtr] == nums[leftPtr]) {
                rightPtr++;
            }
            for (int i = leftPtr + 2; i < rightPtr; i++) {
                nums[i] = Integer.MIN_VALUE;
            }
            leftPtr = rightPtr;
        }
        int ptr = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > -10005) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        return ptr;
    }
}