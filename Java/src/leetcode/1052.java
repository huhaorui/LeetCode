package leetcode;

class Solution_1052 {
    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(new Solution_1052().maxSatisfied(customers, grumpy, 3));
    }

    public int rightPtr(int leftPtr, int K) {
        return leftPtr + K - 1;
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int length = customers.length;
        int[] affect = new int[length]; //由于生气损失是满意数
        int sum = 0; //不控制下的满意数
        for (int i = 0; i < length; i++) {
            affect[i] = customers[i] * grumpy[i];
            sum += customers[i] * (1 - grumpy[i]);
        }
        int solve = 0;
        for (int i = 0; i <= rightPtr(0, X); i++) {
            solve += affect[i];
        }
        int max = solve;
        //目标：找到一个区间K，使得该区间内affect之和最大
        int leftPtr = 0;
        while (rightPtr(leftPtr, X) < length) {
            if (rightPtr(leftPtr, X) + 1 == length) {
                break;
            }
            solve -= affect[leftPtr];
            solve += affect[rightPtr(leftPtr, X) + 1];
            max = Math.max(max, solve);
            leftPtr++;
        }
        return sum + max;
    }
}