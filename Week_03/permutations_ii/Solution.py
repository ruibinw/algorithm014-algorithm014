# 回溯 + 剪枝
# 剪枝条件：i > 0 and nums[i] == nums[i - 1] and not used[i - 1] 去掉重复元素放在同一个格子的分支
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def dfs_permute(path = []):
            if len(path) == n:
                res.append(path[:])
                return
            for i in range(n):
                if used[i] or i > 0 and nums[i] == nums[i - 1] and not used[i - 1]: continue

                path.append(nums[i])
                used[i] = True
                dfs_permute(path)

                path.pop()
                used[i] = False

        n = len(nums)
        res = []
        used = [False] * n
        nums.sort() #剪枝的前提
        dfs_permute()
        return res