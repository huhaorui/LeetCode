package leetcode;

import java.util.Stack;

class Solution_227 {
    public static void main(String[] args) {
        System.out.println(new Solution_227().calculate("1+2+3+4*78"));
    }

    void operate(Stack<Integer> input, int num, char sign) {
        switch (sign) {
            case '+': {
                input.push(num);
                break;
            }
            case '-': {
                input.push(-num);
                break;
            }
            case '*': {
                input.push(input.pop() * num);
                break;
            }
            case '/': {
                input.push(input.pop() / num);
            }
        }
    }

    boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    boolean isBlank(char c) {
        return c == ' ';
    }

    public int calculate(String s) {
        Stack<Integer> input = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (isNum(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } else if (!isBlank(s.charAt(i))) {
                operate(input, num, sign);
                sign = s.charAt(i);
                num = 0;
            }
        }
        operate(input, num, sign);
        return input.stream().mapToInt(it -> it).sum();
    }


}