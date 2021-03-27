package leetcode;

import java.util.Stack;

class Solution_1065 {
    public String removeDuplicates(String S) {
        if (S.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));
                continue;
            }
            if (stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        stack.forEach(sb::append);
        return sb.toString();
    }
}