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
   
    public boolean isSymmetric(TreeNode root) {
    
        //left 순회 재귀
        //right 순회 재귀
        // 값이 다르거나 비어있으면 break & return false
        // 값이 같으면 계속 재귀호출
        //node.left -> node.val
        //node.right -> node.val
        if(root == null) return false;
    
        return isSymmetric(root.left, root.right);
    
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        
    }
    
    
    
}
