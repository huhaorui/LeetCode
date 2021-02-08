import java.util.ArrayList;
import java.util.Arrays;

class Solution_665 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution_665 solution = new Solution_665();
        System.out.println(solution.checkPossibility(nums));
    }

    public boolean checkPossibility(int[] n) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(Integer.MIN_VALUE);
        Arrays.stream(n).forEach(nums::add);
        nums.add(Integer.MAX_VALUE);
        int leftPtr = 0, rightPtr = nums.size() - 1;
        while (leftPtr < rightPtr && nums.get(leftPtr) <= nums.get(leftPtr + 1)) {
            leftPtr++;
        }
        while (leftPtr < rightPtr && nums.get(rightPtr - 1) <= nums.get(rightPtr)) {
            rightPtr--;
        }
        if (leftPtr == rightPtr) {
            return true;
        }
        if (rightPtr - leftPtr > 1) {
            return false;
        }
        if (nums.get(leftPtr + 1) <= nums.get(rightPtr + 1) && nums.get(leftPtr - 1) <= nums.get(leftPtr + 1)) { //修改左边数字
            return true;
        }
        if (nums.get(leftPtr) <= nums.get(rightPtr + 1)) { //修改中间数字
            return true;
        }
        if (nums.get(leftPtr) <= nums.get(rightPtr) && nums.get(leftPtr) <= nums.get(rightPtr + 1)) {//修改右边数字
            return true;
        }
        return false;
    }
}