# 回溯
class Solution1:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def add_or_not(list, i):
            if i > n:
                if len(list) == k: res.append(list)
                return
            add_or_not(list, i + 1)
            add_or_not(list + [i], i + 1)

        add_or_not([], 1)
        return res


# 回溯 + 剪枝
class Solution2:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def backtracking(i = 1, k = k, list = []):
            if k == 0:
                res.append(list)
                return
            if i <= n - k + 1: # 剪枝条件
                backtracking(i + 1, k, list)
                backtracking(i + 1, k - 1, list + [i])

        backtracking()
        return res
