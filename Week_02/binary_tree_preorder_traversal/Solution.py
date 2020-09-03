class Solution1:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        def preorder(root):
            if not root:
                return
            res.append(root.val)
            preorder(root.left)
            preorder(root.right)

        res = []
        preorder(root)
        return res


class Solution2:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = [root] if root else []
        while stack:
            node = stack.pop()
            if node:
                res.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return res


