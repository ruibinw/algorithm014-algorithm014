# 维护两个变量，当前最小乘积 cur_min，和当前最大乘积 cur_max
class Solution1:
    def maxProduct(self, nums: List[int]) -> int:
        cur_max, cur_min, max_so_far = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            if nums[i] < 0:
                cur_max, cur_min = cur_min, cur_max
            cur_max = max(cur_max * nums[i], nums[i])
            cur_min = min(cur_min * nums[i], nums[i])
            max_so_far = max(max_so_far, cur_max)
        return max_so_far