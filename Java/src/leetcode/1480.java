package leetcode;

class Solution_1480 {
    public int[] runningSum(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        ans[0] = nums[0];
        for (int i = 1; i < size; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }
}