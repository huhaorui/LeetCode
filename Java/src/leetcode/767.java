package leetcode;

import java.util.stream.IntStream;

class Solution_767 {
    public static void main(String[] args) {
        System.out.println(new Solution_767().reorganizeString("aaaaaaaab"));
    }

    public int getChar(int[] chars, int forbidden) {
        int maxSeat = forbidden == 0 ? 1 : 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > chars[maxSeat] && i != forbidden) {
                maxSeat = i;
            }
        }
        chars[maxSeat]--;
        if (chars[maxSeat] < 0)
            return -1;
        return maxSeat;
    }

    public String reorganizeString(String S) {
        int[] chars = new int[26];
        int length = S.length();
        IntStream.range(0, S.length()).forEach(i -> chars[S.charAt(i) - 'a']++);
        StringBuilder ans = new StringBuilder(length);
        int forbidden = -1;
        while (length-- > 0) {
            forbidden = getChar(chars, forbidden);
            if (forbidden == -1) {
                return "";
            }
            ans.append((char) ('a' + forbidden));
        }
        return ans.toString();
    }
}