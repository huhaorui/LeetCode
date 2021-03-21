import java.util.Arrays;
import java.util.Stack;

class Solution_150 {
    public static void main(String[] args) {
        String[] ops = {"2", "1", "+", "3", "*"};
        System.out.println(new Solution_150().evalRPN(ops));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        Arrays.stream(tokens).forEach(it -> {
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
                    break;
                }
                default: {
                    numbers.push(Integer.valueOf(it));
                }
            }
        });
        return numbers.pop();
    }
}