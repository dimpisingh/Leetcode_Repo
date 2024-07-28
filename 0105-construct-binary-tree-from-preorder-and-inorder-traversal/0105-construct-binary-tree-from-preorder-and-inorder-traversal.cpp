/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.empty() || inorder.empty()) {
            return nullptr;
        }
        TreeNode* root = new TreeNode(preorder[0]);
        auto mid =
            find(inorder.begin(), inorder.end(), preorder[0]) - inorder.begin();
        vector<int> inLeft(inorder.begin(), inorder.begin() + mid);
        vector<int> inRight(inorder.begin() + mid + 1, inorder.end());
        vector<int> leftPre(preorder.begin() + 1, preorder.begin() + mid + 1);
        vector<int> rightPre(preorder.begin() + mid + 1, preorder.end());
        root->left = buildTree(leftPre, inLeft);
        root->right = buildTree(rightPre, inRight);
        return root;
    }
};