package leetcode;

import java.util.Arrays;

class Solution_179 {
    public String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        Arrays.stream(nums).boxed().sorted((x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        }).forEach(ans::append);
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans.toString();
    }
}