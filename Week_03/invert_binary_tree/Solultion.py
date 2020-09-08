# DFS
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root:
            root.left, root.right = root.right, root.left
            self.invertTree(root.left)
            self.invertTree(root.right)
        return root


# BFS
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None

        q = [root]
        while q:
            cur = q.pop(0)
            if cur.left or cur.right:
                cur.left, cur.right = cur.right, cur.left
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
        return root
