class Solution_485 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 1};
        System.out.println(new Solution_485().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int num = 0;
        for (int n : nums) {
            if (n == 1) num++;
            if (n == 0) num = 0;
            if (num > max) max = num;
        }
        return max;
    }
}