/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    
    
    function dfs1(node){ // DLR
        left += node.val;
        node.left === null ? left += "n" : dfs1(node.left);
        node.right === null ? left += "n" : dfs1(node.right);
    }
    function dfs2(node){ // DRL
        right += node.val;
        node.right === null ? right += "n" : dfs2(node.right);
        node.left === null ? right += "n" : dfs2(node.left);
    }
    
    let left = "";
    let right = "";
    
    root.left === null ? left += "n" : dfs1(root.left);
    root.right === null ? right += "n" : dfs2(root.right);

    return left === right;
    
    
};
