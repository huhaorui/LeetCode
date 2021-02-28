class Solution_395 {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int length = s.length();
        for (int t = 1; t <= 26; t++) {
            int leftPtr = 0, rightPtr = 0;
            int[] appear = new int[26];
            int tot = 0;
            int less = 0;
            while (rightPtr < length) {
                appear[s.charAt(rightPtr) - 'a']++;
                if (appear[s.charAt(rightPtr) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (appear[s.charAt(rightPtr) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    appear[s.charAt(leftPtr) - 'a']--;
                    if (appear[s.charAt(leftPtr) - 'a'] == k - 1) {
                        less++;
                    }
                    if (appear[s.charAt(leftPtr) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    leftPtr++;
                }
                if (less == 0) {
                    ans = Math.max(ans, rightPtr - leftPtr + 1);
                }
                rightPtr++;
            }
        }
        return ans;
    }
}