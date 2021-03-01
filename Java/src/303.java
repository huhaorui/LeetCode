class NumArray {
    int[] sum;
    int length;

    public NumArray(int[] nums) {
        length = nums.length;
        sum = new int[length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 5));
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/*
  Your NumArray object will be instantiated and called as such:
  NumArray obj = new NumArray(nums);
  int param_1 = obj.sumRange(i,j);
 */