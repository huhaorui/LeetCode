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



class Solution_145 {
    public void postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postorderTraversal(root.left, ans);
        }
        if (root.right != null) {
            postorderTraversal(root.right, ans);
        }
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans);
        return ans;
    }
}