import java.util.Arrays;

class Solution_73 {
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0}, {0, 5, 6}};
        new Solution_73().setZeroes(nums);
    }

    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        boolean[] m = new boolean[height];
        boolean[] n = new boolean[width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = true;
                    n[j] = true;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            if (m[i]) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < width; i++) {
            if (n[i]) {
                for (int j = 0; j < height; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}