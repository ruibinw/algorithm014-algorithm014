# 维护两个变量，当前最小乘积 cur_min，和当前最大乘积 cur_max
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        cur_max = cur_min = max_prd = nums[0]
        for n in nums[1:]:
            if n < 0: cur_max, cur_min = cur_min, cur_max
            cur_max = max(cur_max * n, n)
            cur_min = min(cur_min * n, n)
            max_prd = max(max_prd, cur_max)
        return max_prd