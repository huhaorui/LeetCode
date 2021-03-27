package leetcode;

class GuessGame {
    int ans = 123;

    int guess(int num) {
        return Integer.compare(ans, num);
    }
}

class Solution_374 extends GuessGame {
    public static void main(String[] args) {
        System.out.println(new Solution_374().guessNumber(333));
    }

    public int guessNumber(int num) {
        int leftPtr = 1;
        int rightPtr = num;
        while (true) {
            int guess = leftPtr + (rightPtr - leftPtr) / 2;
            switch (guess(guess)) {
                case -1: {
                    rightPtr = guess - 1;
                    break;
                }
                case 0: {
                    return guess;
                }
                case 1: {
                    leftPtr = guess + 1;
                }
            }
        }
    }
}