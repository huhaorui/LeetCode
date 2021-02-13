struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    TreeNode *insertIntoBST(TreeNode *root, int val) {
        if (val > root->val && root->right) {
            insertIntoBST(root->right, val);
        } else if (val < root->val && root->left) {
            insertIntoBST(root->left, val);
        } else if (val > root->val && !root->right) {
            root->right = new TreeNode(val);
        } else {
            root->left = new TreeNode(val);
        }
        return root;
    }
};