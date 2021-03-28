package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTIterator {
    List<Integer> nums = new ArrayList<>();
    int ptr = 0;

    public BSTIterator(TreeNode root) {
        search(root);
    }

    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        search(node.left);
        nums.add(node.val);
        search(node.right);
    }

    public int next() {
        return nums.get(ptr++);
    }

    public boolean hasNext() {
        return ptr < nums.size();
    }
}

/*
  Your BSTIterator object will be instantiated and called as such:
  BSTIterator obj = new BSTIterator(root);
  int param_1 = obj.next();
  boolean param_2 = obj.hasNext();
 */