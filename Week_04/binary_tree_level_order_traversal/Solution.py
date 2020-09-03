# DFS
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        def dfs(root, level = 0):
            if root is None:
                return
            if len(res) == level:
                res.append([root.val])
            else:
                res[level].append(root.val)
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)

        res = []
        dfs(root)
        return res


# BFS
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        q = collections.deque()
        if root: q.append(root)
        while q:
            n = len(q)
            row = []
            for _ in range(n):
                node = q.popleft()
                row.append(node.val)
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            res.append(row)
        return res