package leetcode;

import java.util.Arrays;

class Solution_1423 {
    public static void main(String[] args) {
        int[] card = {1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;
        Solution_1423 solution = new Solution_1423();
        System.out.println(solution.maxScore(card, k));
    }

    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int left = 0;
        int min = Arrays.stream(cardPoints).limit(length - k).sum();
        int num = min;
        int sum = Arrays.stream(cardPoints).sum();
        while (left < k) {
            num -= cardPoints[left];
            num += cardPoints[left + length - k];
            if (num < min) min = num;
            left++;
        }
        return sum - min;
    }
}