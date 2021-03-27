package leetcode;

import java.util.Arrays;

class Solution_567 {
    public static void main(String[] args) {
        System.out.println(new Solution_567().checkInclusion("abc", "eidbaoooabdabd"));
    }


    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length2 < length1)
            return false;
        int[] appear1 = new int[26];
        int[] appear2 = new int[26];
        for (int i = 0; i < length1; i++) {
            appear1[s1.charAt(i) - 'a']++;
            appear2[s2.charAt(i) - 'a']++;
        }

        int leftPtr = -1;
        while (leftPtr + length1 < length2) {
            leftPtr++;
            if (Arrays.equals(appear1, appear2)) {
                return true;
            }
            if (leftPtr + length1 == length2)
                return false;
            appear2[s2.charAt(leftPtr) - 'a']--;
            appear2[s2.charAt(leftPtr + length1) - 'a']++;
        }
        return false;
    }
}