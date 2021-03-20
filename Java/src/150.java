import java.util.Arrays;
import java.util.Stack;

class Solution_150 {
    public static void main(String[] args) {
        String[] ops = {"2", "1", "+", "3", "*"};
        System.out.println(new Solution_150().evalRPN(ops));
    }

    boolean isOp(String op) {
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*");
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        Arrays.stream(tokens).forEach(it -> {
            if (!isOp(it)) {
                numbers.push(Integer.parseInt(it));
            } else {
                switch (it) {
                    case "+": {
                        numbers.push(numbers.pop() + numbers.pop());
                        break;
                    }
                    case "-": {
                        numbers.push(-numbers.pop() + numbers.pop());
                        break;
                    }
                    case "*": {
                        numbers.push(numbers.pop() * numbers.pop());
                        break;
                    }
                    case "/": {
                        int num1 = numbers.pop();
                        int num2 = numbers.pop();
                        numbers.push(num2 / num1);
                    }
                }
            }
        });
        return numbers.pop();
    }
}