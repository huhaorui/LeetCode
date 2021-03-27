package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution_131 {
    int[][] find;
    int length;
    String input;
    List<List<String>> ans = new ArrayList<>();
    List<String> chars = new ArrayList<>();

    public int isPalindrome(int i, int j) {
        if (find[i][j] != 0) {
            return find[i][j];
        }
        if (i >= j) {
            find[i][j] = 1;
        } else if (input.charAt(i) == input.charAt(j)) {
            find[i][j] = isPalindrome(i + 1, j - 1);
        } else {
            find[i][j] = -1;
        }
        return find[i][j];
    }

    public void dfs(String s, int i) {
        if (i == length) {
            ans.add(new ArrayList<>(chars));
            return;
        }
        for (int j = i; j < length; ++j) {
            if (isPalindrome(i, j) == 1) {
                chars.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                chars.remove(chars.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        length = s.length();
        find = new int[length][length];
        input = s;
        dfs(s, 0);
        return ans;
    }
}