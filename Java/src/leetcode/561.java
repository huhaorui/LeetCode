package leetcode;

import java.util.Arrays;

class Solution_561 {
    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println(new Solution_561().arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}