package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class MyHashList {
    List<List<Integer>> nums = new ArrayList<>();

    public MyHashList() {
        for (int i = 0; i < 876; i++) {
            nums.add(new ArrayList<>());
        }
    }

    private int hash(int n) {
        return Math.abs(n % 876);
    }

    void add(int n) {
        nums.get(hash(n)).add(n);
    }

    boolean exist(int n) {
        AtomicBoolean exist = new AtomicBoolean(false);
        nums.get(hash(n)).forEach(it -> {
            if (it.equals(n)) {
                exist.set(true);
            }
        });
        return exist.get();
    }
}

class Solution_1 {
    MyHashList list = new MyHashList();

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(new Solution_1().twoSum(nums, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Arrays.stream(nums).forEach(it -> {
            list.add(it);
        });
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (list.exist(target - nums[i])) {
                ans[0] = i;
                for (int j = 0; j < nums.length; j++) {
                    if (target - nums[i] == nums[j]) {
                        ans[1] = j;
                        break;
                    }
                }
                if (ans[0] != ans[1])
                    break;
            }
        }
        return ans;
    }
}