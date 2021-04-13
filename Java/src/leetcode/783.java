package leetcode;

class Solution_783 {
    int min = Integer.MAX_VALUE - 100000;
    int prev = Integer.MIN_VALUE + 100000;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        System.out.println(new Solution_783().minDiffInBST(root));
    }

    void CAS(int n) {
        min = Math.min(min, Math.abs(n - prev));
        prev = n;
    }

    void traverse(TreeNode node) {
        if (node.left != null) {
            traverse(node.left);
        }
        CAS(node.val);
        if (node.right != null) {
            traverse(node.right);
        }
    }

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return min;
    }
}