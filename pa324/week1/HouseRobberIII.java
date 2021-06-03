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
    public int rob(TreeNode root) {
        int [] answer = doRob(root);
        return Math.max(answer[0],answer[1]);
    }
    private int[] doRob(TreeNode root) {
        if(root == null) {
            return new int[] {0,0};
        }
        int [] left = doRob(root.left);
        int [] right = doRob(root.right);
      
        
        int [] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
