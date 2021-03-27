package leetcode;

import java.util.Arrays;

class Solution_832 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(new Solution_832().flipAndInvertImage(nums)));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int width = A[0].length;
        for (int[] row : A) {
            int leftPtr = 0, rightPtr = width - 1;
            while (leftPtr < rightPtr) {
                int tmp = row[leftPtr];
                row[leftPtr] = row[rightPtr] ^ 1;
                row[rightPtr] = tmp ^ 1;
                leftPtr++;
                rightPtr--;
            }
            if (leftPtr == rightPtr) {
                row[leftPtr] ^= 1;
            }
        }
        return A;
    }


}