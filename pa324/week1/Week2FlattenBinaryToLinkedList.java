/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
       
        dfs(root);
    }
    public TreeNode dfs(TreeNode node) {
        if(node == null) {
            return null;
        }
        
        TreeNode leftSubTree = dfs(node.left);
        TreeNode rightSubTree = dfs(node.right);
        
        if(leftSubTree != null) {
            node.right = leftSubTree;
            node.left = null;        
        }
    
        
        TreeNode leaf = leftSubTree;
        while(leaf != null && leaf.right != null) {
            leaf = leaf.right;
        }
       
        if(leaf != null) {
            leaf.right = rightSubTree;
        }
        
        return node;
    }
}
