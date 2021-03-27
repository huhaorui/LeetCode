package leetcode;

class Solution_3 {
    public static void main(String[] args) {
        System.out.println(new Solution_3().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int[] appear = new int[128];
        int leftPtr = 0, rightPtr = 0;
        int max = 0;
        while (rightPtr < length) {
            int n = s.charAt(rightPtr);
            appear[n]++;
            rightPtr++;
            while (appear[n] > 1) {
                appear[s.charAt(leftPtr)]--;
                leftPtr++;
            }
            if (rightPtr - leftPtr + 1 > max)
                max = rightPtr - leftPtr;
        }
        return max;
    }
}