package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_1178 {
    public static void main(String[] args) {
        String[] words = new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        System.out.println(new Solution_1178().findNumOfValidWords(words, puzzles));
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);
            ans.add(total);
        }
        return ans;
    }
}
