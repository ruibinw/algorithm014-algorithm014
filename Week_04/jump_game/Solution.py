class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_loc, loc, end = 0, 0, len(nums) - 1
        while loc <= max_loc:
            max_loc = max(max_loc, loc + nums[loc])
            if max_loc >= end:
                return True
            loc += 1
        return False