package leetcode;

class Solution_1456 {
    public static void main(String[] args) {
        System.out.println(new Solution_1456().maxVowels("abciiidef", 3));
    }

    public int maxVowels(String s, int k) {
//        ArrayList<Character> vowel = new ArrayList<>();
//        vowel.add('a');
//        vowel.add('e');
//        vowel.add('i');
//        vowel.add('o');
//        vowel.add('u');
        char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
        int length = s.length();
        int leftPtr = 0;
        int max = 0;
        for (int i = leftPtr; i <= leftPtr + k - 1; i++) {
            for (char c : vowel) {
                if (c == s.charAt(i)) {
                    max++;
                    break;
                }
            }
        }
        int now = max;
        while (leftPtr + k < length) {
            for (char c : vowel) {
                if (c == s.charAt(leftPtr)) {
                    now--;
                    break;
                }
            }
            leftPtr++;
            for (char c : vowel) {
                if (c == s.charAt(leftPtr + k - 1)) {
                    now++;
                    break;
                }
            }
            max = Math.max(now, max);
        }
        return max;
    }
}