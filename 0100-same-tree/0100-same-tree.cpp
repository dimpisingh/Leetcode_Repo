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
    bool isSubtree(TreeNode* r, TreeNode* s) {
        if (!s)
            return true;
        if (!r)
            return false;
        if (isSameTree(r, s))
            return true;
        return (isSubtree(r->left, s) || isSubtree(r->right, s));
    }
    bool isSameTree(TreeNode* r, TreeNode* s) {
        if (!r && !s)
            return true;
        if (r && s && r->val == s->val) {
            return (isSameTree(r->left, s->left) &&
                    isSameTree(r->right, s->right));
        } else
            return false;
    }
};