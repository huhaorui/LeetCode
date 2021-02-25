import java.util.Arrays;

class Solution_867 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(new Solution_867().transpose(matrix)));
    }

    public int[][] transpose(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int[][] ans = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }
}