from typing import List

# 递归回溯
# Time: O(2^n), 每个元素有两种选择，放或者不放
# Space: O(2^n)
class Solution1:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []

        def backtracking(i=0, path=[]):
            if i == n:
                res.append(path[:]) # 拷贝保存
                return
            path.append(nums[i])
            backtracking(i + 1, path)  # 放元素
            path.pop()
            backtracking(i + 1, path)  # 不放元素

        backtracking()
        return res

print(Solution1().subsets([1,2,3]))

# 循环，从第一个空子集开始，每次向子集添加新的整数
class Solution2:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for num in nums:
            res += (cur + [num] for cur in res)
        return res
