import java.util.*;

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
class p114 {
    static List<TreeNode> arr = new ArrayList<>();
    public void flatten(TreeNode root) {
        preorder(root);
        TreeNode prev = arr.get(0);
        for (int i = 1; i < arr.size(); i++){
            TreeNode cur = arr.get(i);
            prev.left = null;
            prev.right = cur;
            prev = cur;
        }
        prev.left = null;
        prev.right = null;
    }
    public void preorder(TreeNode root) {
        if (root == null) return;
        arr.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}