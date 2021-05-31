class Solution {
    unordered_map<TreeNode*, int> m;
public:
    int rob(TreeNode* root) {
        if (root == nullptr) return 0;
        if (m.find(root) != m.end()) return m[root];
        
        int total = 0;
        if (root->left) total += (rob(root->left->left) + rob(root->left->right));
        if (root->right) total += (rob(root->right->left) + rob(root->right->right));
        return m[root] = max(total + root->val , (rob(root->left) + rob(root->right)));
    }
};
