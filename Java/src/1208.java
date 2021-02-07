class Solution_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] cost = new int[length];
        for (int i = 0; i < length; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int rightPtr = 0, leftPtr = 0, max = 0, nowCost = 0;
        while (rightPtr < length) {
            nowCost += cost[rightPtr];
            while (nowCost > maxCost) {
                nowCost -= cost[leftPtr];
                leftPtr++;
            }
            if (rightPtr - leftPtr + 1 > max) {
                max = rightPtr - leftPtr + 1;
            }
            rightPtr++;
        }
        return max;
    }
}