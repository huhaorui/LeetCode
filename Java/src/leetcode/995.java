package leetcode;

import java.util.Deque;
import java.util.LinkedList;

class Solution_995 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0};
        System.out.println(new Solution_995().minKBitFlips(nums, 2));
    }

    public int minKBitFlips(int[] A, int K) {
        int length = A.length;
        Deque<Integer> transformRange = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (!transformRange.isEmpty() && transformRange.peekFirst() == i) {
                transformRange.pollFirst();
            }
            int cur = A[i] + transformRange.size();
            if (cur % 2 == 0) {
                if (i + K > length) {
                    return -1;
                }
                transformRange.offerLast(i + K);
                ans++;
            }
        }
        return ans;
    }
}