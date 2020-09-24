from typing import List

class Solution1:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs_find_permutations(list = []):
            if len(list) == n:
                res.append(list)
                return
            for i in range(n):
                if used[i]: continue
                used[i] = True
                dfs_find_permutations(list + [nums[i]]) #list+list in python will generate new list
                used[i] = False

        n = len(nums)
        used = [False] * n
        res = []
        dfs_find_permutations()
        return res


class Solution2:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs_permute(path = []):
            if len(path) == n:
                res.append(path[:])
                return
            for i in range(n):
                if used[i]: continue

                path.append(nums[i])
                used[i] = True
                dfs_permute(path)

                path.pop()
                used[i] = False

        n = len(nums)
        res = []
        used = [False] * n
        dfs_permute()
        return res
