package leetcode;

import java.util.Arrays;

class Solution {
    public boolean search(int[] nums, int target) {
        return Arrays.stream(nums).filter(it -> it == target).count() >= 1;
    }
}