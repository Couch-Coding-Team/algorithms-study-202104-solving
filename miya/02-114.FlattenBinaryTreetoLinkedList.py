# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def helper(node:TreeNode):
            if not node:
                return None
            if not node.left and not node.right:
                return node
            
            left = helper(node.left)
            right = helper(node.right)
            if left:
                left.right = node.right
                node.right = node.left
                node.left = None
            return right if right else left
        
        helper(root)
           