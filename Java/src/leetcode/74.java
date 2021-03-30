package leetcode;

class Solution_74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 12, 13}, {14, 15, 16, 17}};
        System.out.println(new Solution_74().searchMatrix(matrix, 3));
    }

    Point map(int n, int width) {
        return new Point(n / width, n % width);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int size = height * width;
        int i = 0, j = size - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            Point p = map(m, width);
            if (matrix[p.x][p.y] == target) {
                return true;
            } else if (matrix[p.x][p.y] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}