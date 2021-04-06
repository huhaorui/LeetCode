package leetcode;

class Solution_343 {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int three = n / 3;
        switch (n % 3) {
            case 0:
                return (int) Math.pow(3, three);
            case 1:
                return (int) Math.pow(3, three - 1) * 4;
            case 2:
                return (int) Math.pow(3, three) * 2;
        }
        return 0;
    }
}