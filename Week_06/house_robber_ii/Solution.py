class Solution:
    def rob(self, nums: List[int]) -> int:
        def rob_helper(start, end):
            pre = cur = 0
            for i in range(start, end):
                cur, pre = max(cur, pre + nums[i]), cur
            return cur

        n = len(nums)
        return max(rob_helper(0, n - 1), rob_helper(1, n)) if n > 1 else nums[0] if n == 1 else 0

