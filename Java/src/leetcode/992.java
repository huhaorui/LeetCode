package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution_992 {
    public static void main(String[] args) {
        Solution_992 solution = new Solution_992();
        int[] A = {1, 2, 1, 3, 4};
        System.out.println(solution.subarraysWithKDistinct(A, 3));
    }


    public int subarraysWithKDistinct(int[] A, int K) {
        int ans = 0;
        int length = A.length;
        int leftPtr = 0, rightPtr = 0;
        Map<Integer, AtomicInteger> find = new HashMap<>();
        int count = 0;
        while (rightPtr < length && count < K) {
            if (find.containsKey(A[rightPtr])) {
                find.get(A[rightPtr]).incrementAndGet();
            } else {
                find.put(A[rightPtr], new AtomicInteger(1));
                count++;
            }
            if (count < K)
                rightPtr++;
        }
        while (rightPtr < length) {
            while (count > K) { //过多了，左边右移，直到数量合适。是一个解
                if (find.get(A[leftPtr]).decrementAndGet() == 0) {
                    count--;
                    find.remove(A[leftPtr]);
                }
                leftPtr++;
            }
            int left_backup = leftPtr;
            if (count == K) {
                if (find.get(A[leftPtr]).decrementAndGet() == 0) {
                    count--;
                    find.remove(A[leftPtr]);
                }
                ans++;
                leftPtr++;
            }
            while (count == K) {//左边不断右移，寻找解
                if (find.get(A[leftPtr]).decrementAndGet() == 0) {
                    count--;
                    find.remove(A[leftPtr]);
                }
                leftPtr++;
                ans++;
            }
            while (leftPtr > left_backup) {
                leftPtr--;
                if (find.containsKey(A[leftPtr])) {
                    find.get(A[leftPtr]).incrementAndGet();
                } else {
                    find.put(A[leftPtr], new AtomicInteger(1));
                    count++;
                }
            }
            rightPtr++;
            if (rightPtr == length)
                return ans;
            if (find.containsKey(A[rightPtr])) {
                find.get(A[rightPtr]).incrementAndGet();
            } else {
                find.put(A[rightPtr], new AtomicInteger(1));
                count++;
            }
        }
        return ans;
    }
}