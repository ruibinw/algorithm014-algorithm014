class Solution1:
    def inorder_traversal(self, root: TreeNode) -> List[int]:
        def dfs(root, res):
            if not root:
                return
            dfs(root.left, res)
            res.append(root.val)
            dfs(root.right, res)

        res = []
        dfs(root, res)
        return res


class Solution2:
    def inorder_traversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            res.append(root.val)
            root = root.right
        return res

