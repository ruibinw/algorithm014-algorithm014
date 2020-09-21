class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum_so_far, cur_max_sum = -sys.maxsize, 0
        for num in nums:
            cur_max_sum = max(cur_max_sum + num, num)
            max_sum_so_far = max(max_sum_so_far, cur_max_sum)
        return max_sum