import java.util.Arrays;

class Solution_566 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {3, 4, 5}};
        System.out.println(Arrays.deepToString(new Solution_566().matrixReshape(nums, 3, 2)));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int size = nums.length * nums[0].length;
        int[][] ans = new int[r][c];
        if (r * c != size) {
            return nums;
        }
        int r0 = 0, c0 = 0;
        for (var row : nums) {
            for (var num : row) {
                ans[r0][c0] = num;
                c0++;
                if (c0 == c) {
                    r0++;
                    c0 = 0;
                }
            }
        }
        return ans;
    }
}