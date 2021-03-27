package leetcode;

class Solution_766 {
    public boolean same(int[] prev, int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (prev[i - 1] != nums[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int[] prev = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            if (!same(prev, matrix[i])) {
                return false;
            } else {
                prev = matrix[i];
            }
        }
        return true;
    }
}