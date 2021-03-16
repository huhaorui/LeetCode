import java.util.Arrays;

/**
 * 1   2   3   4
 * 12  13  14  5
 * 11  16  15  6
 * 10  9   8   7
 */
class Solution_59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution_59().generateMatrix(10)));
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int k = 1;
        int xPtr = 0, yPtr = 0;
        while (k <= n * n) {
            while (xPtr < n && ans[yPtr][xPtr] == 0) {
                ans[yPtr][xPtr] = k;
                xPtr++;
                k++;
            }
            xPtr--;
            yPtr++;
            while (yPtr < n && ans[yPtr][xPtr] == 0) {
                ans[yPtr][xPtr] = k;
                yPtr++;
                k++;
            }
            yPtr--;
            xPtr--;
            while (xPtr >= 0 && ans[yPtr][xPtr] == 0) {
                ans[yPtr][xPtr] = k;
                xPtr--;
                k++;
            }
            xPtr++;
            yPtr--;
            while (yPtr >= 0 && ans[yPtr][xPtr] == 0) {
                ans[yPtr][xPtr] = k;
                yPtr--;
                k++;
            }
            yPtr++;
            xPtr++;
        }
        return ans;
    }
}