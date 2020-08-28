import sys
from typing import List


# 暴力法
class Solution1:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        n = len(nums) - k + 1
        for i in range(n):
            max_num = -sys.maxsize  # minus maxsize to get minsize (no minsize in python)
            for j in range(i, i + k):
                max_num = max(max_num, nums[j])
            res.append(max_num)
        return res


# 使用只保留最大值的队列
class Solution2:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:

        class MaxQueue:
            def __init__(self):
                self.q = []

            def push(self, num):
                while self.q and self.q[-1] < num: self.q.pop()
                self.q.append(num)

            def pop(self, num):
                if self.q[0] == num: self.q.pop(0)

            def get_max(self):
                return self.q[0]

        result = []
        window = MaxQueue(nums[:k - 1])
        for i in range(k - 1, len(nums)):
            if i < k - 1:
                window.push(nums[i])
            else:
                window.push(nums[i])
                result.append(window.get_max())
                window.pop(nums[i - k + 1])

        return result


# 动态规划
class Solution2:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]: ...
