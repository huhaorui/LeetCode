package leetcode;

import java.util.PriorityQueue;

class Solution_1438 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 2, 2, 4, 4, 2, 2};
        System.out.println(new Solution_1438().longestSubarray(nums, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int length = nums.length;
        int leftPtr = 0, rightPtr = 0;
        int ans = 0;
        while (rightPtr < length) {
            max.add(nums[rightPtr]);
            min.add(nums[rightPtr]);
            while (max.peek() - min.peek() > limit) {
                max.remove(nums[leftPtr]);
                min.remove(nums[leftPtr]);
                leftPtr++;
            }
            ans = Math.max(ans, rightPtr - leftPtr + 1);
            rightPtr++;
        }
        return ans;
    }
}