package xyy;

import leetcode.TreeNode;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int should = (length) * (length + 1) / 2;
        return should - Arrays.stream(nums).sum();
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!balance(countHeight(root.left), countHeight(root.right))) {
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    public boolean balance(int n1, int n2) {
        return n1 == n2 || n1 - n2 == 1 || n2 - n1 == 1;
    }

    public int countHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(countHeight(root.left), countHeight(root.right)) + 1;
    }

    public double[] dicesProbability(int n) {
        double[][] ans = new double[n + 1][5 * n + 1];
        ans[1] = new double[]{1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int t = 2; t <= n; t++) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5 * t - 4; j++) {
                    ans[t][i + j] += ans[1][i] * ans[t - 1][j];
                }
            }
        }
        return ans[n];
    }

    //7 5 6 4
    //4 5 6 7
    public int reversePairs(int[] nums) {
        int ans;
        List<Integer> target = new Vector<>();
        ans = Arrays.stream(nums).map(it -> insertNum(it, target)).sum();
        return ans;
    }

    /**
     * 向有序链表中插入数
     *
     * @param num    被插入的数
     * @param target 目标链表
     * @return 它右边的个数
     */
    public int insertNum(int num, List<Integer> target) {
        int index = Collections.binarySearch(target, num);
        if (index < 0) {
            index = -index - 1;
        } else {
            while (target.size() > index && target.get(index + 1) == num) {
                index++;
            }
        }
        target.add(index, num);
        return target.size() - index - 1;
    }
}