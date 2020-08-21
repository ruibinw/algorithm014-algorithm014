import sys
from typing import List

# 暴力法
class Solution1:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        n = len(nums) - k + 1
        for i in range(n):
            max_num = -sys.maxsize
            for j in range(i, i + k):
                max_num = max(max_num, nums[j])
            res.append(max_num)
        return res

# 使用队列
