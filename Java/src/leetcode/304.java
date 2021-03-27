package leetcode;

class NumMatrix {
    int[][] nums;
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        nums = matrix;
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + nums[i - 1][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}};
        NumMatrix numMatrix = new NumMatrix(nums);
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}

/*
  Your NumMatrix object will be instantiated and called as such:
  NumMatrix obj = new NumMatrix(matrix);
  int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */