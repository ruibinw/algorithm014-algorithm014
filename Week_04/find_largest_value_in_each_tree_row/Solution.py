# DFS
class Solution1:
    def largestValues(self, root: TreeNode) -> List[int]:
        def dfs_compare(root, level = 0):
            if root is None:
                return
            if len(max_list) == level:
                max_list.append(-sys.maxsize)
            if root.val > max_list[level]:
                max_list[level] = root.val
            dfs_compare(root.left, level + 1)
            dfs_compare(root.right, level + 1)

        max_list = []
        dfs_compare(root)
        return max_list


# BFS
class Solution2:
    def largestValues(self, root: TreeNode) -> List[int]:
        max_list = []
        dq = collections.deque([root]) if root else []
        while dq:
            max_val = -sys.maxsize
            size = len(dq)
            for _ in range(size):
                node = dq.popleft()
                max_val = max(max_val, node.val)
                if node.left: dq.append(node.left)
                if node.right: dq.append(node.right)
            max_list.append(max_val)
        return max_list


# more concise and pythonic code
class Solution2:
    def largestValues(self, root: TreeNode) -> List[int]:
        max_list = []
        row = [root]
        while any(row):
            max_list.append(max(node.val for node in row))
            row = [child for node in row for child in (node.left, node.right) if child]
        return max_list
