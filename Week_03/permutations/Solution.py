from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs_find_permutations(list = []):
            if len(list) == n:
                res.append(list)
                return
            for i in range(n):
                if used[i]: continue
                used[i] = True
                dfs_find_permutations(list + [nums[i]])
                used[i] = False

        n = len(nums)
        used = [False] * n
        res = []
        dfs_find_permutations()
        return res


res = Solution().permute([1,2,3])
print(res)