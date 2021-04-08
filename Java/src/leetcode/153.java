package leetcode;

import java.util.Arrays;

class Solution_153 {
    public int findMin(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }
}