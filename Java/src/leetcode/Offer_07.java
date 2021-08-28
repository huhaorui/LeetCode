package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getSubTree(Arrays.stream(preorder).boxed().collect(Collectors.toList()), Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode getSubTree(List<Integer> preorder, List<Integer> inorder) {
        return preorder.isEmpty() ? null : new TreeNode(preorder.get(0), inorder.indexOf(preorder.get(0)) >= 1 ? getSubTree(preorder.subList(1, inorder.indexOf(preorder.get(0)) + 1), inorder.subList(0, inorder.indexOf(preorder.get(0)))) : null, inorder.indexOf(preorder.get(0)) + 1 < preorder.size() ? getSubTree(preorder.subList(inorder.indexOf(preorder.get(0)) + 1, preorder.size()), inorder.subList(inorder.indexOf(preorder.get(0)) + 1, inorder.size())) : null);
    }
}
