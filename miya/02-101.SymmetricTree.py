class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def helper(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            return helper(left.right, right.left) and helper(right.left, left.right)
        return helper(root, root)