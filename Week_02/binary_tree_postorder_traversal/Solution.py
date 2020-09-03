class Solution1:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        def traversal(root):
            if not root:
                return
            traversal(root.left)
            traversal(root.right)
            res.append(root.val)

        res = []
        traversal(root)
        return res


class Solution2:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = [root] if root else []
        while stack:
            p = stack.pop()
            if p:
                stack.append(p)
                stack.append(None)
                if p.right: stack.append(p.right)
                if p.left: stack.append(p.left)
            else:
                res.append(stack.pop().val)
        return res

