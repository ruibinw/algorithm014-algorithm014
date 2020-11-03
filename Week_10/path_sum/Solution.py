class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False

        queue = [(root, root.val)]
        while queue:
            node, val = queue.pop()
            if not node.left and not node.right and val == sum:
                return True
            if node.left:
                queue.append((node.left, val + node.left.val))
            if node.right:
                queue.append((node.right, val + node.right.val))
        return False