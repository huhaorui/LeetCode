package leetcode;

class Solution_338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i < num; i += 2) {
            ans[i] = ans[i / 2] + 1;
            ans[i + 1] = ans[i / 2 + 1];
        }
        if (num % 2 == 1) {
            ans[num] = ans[num / 2] + 1;
        }
        return ans;
    }
}