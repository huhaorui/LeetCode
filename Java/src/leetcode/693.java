package leetcode;

class Solution_693 {
    public static void main(String[] args) {
        System.out.println(new Solution_693().hasAlternatingBits(5));
    }

    public boolean hasAlternatingBits(int n) {
        int flag = n % 2;
        n /= 2;
        while (n > 0) {
            if (n % 2 + flag != 1) {
                return false;
            }
            flag = 1 - flag;
            n /= 2;
        }
        return true;
    }
}