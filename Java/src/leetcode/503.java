package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < length * 2; i++) {
            while (!d.isEmpty() && nums[i % length] > nums[d.peekLast()]) {
                int u = d.pollLast();
                ans[u] = nums[i % length];
            }
            d.addLast(i % length);
        }
        return ans;
    }
}
