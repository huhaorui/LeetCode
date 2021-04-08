package leetcode;

import java.util.Arrays;

class Solution_81 {
    public boolean search(int[] nums, int target) {
        return Arrays.stream(nums).parallel().filter(it -> it == target).count() >= 1;
    }
}