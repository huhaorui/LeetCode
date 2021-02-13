import java.util.LinkedList;
import java.util.List;

class Solution_448 {
    public static void main(String[] args) {
        Solution_448 solution = new Solution_448();
        int[] nums = {4, 2, 3, 4};
        System.out.println(solution.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            nums[num] = -Math.abs(nums[num]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}