from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        jmp, cur_end, max_loc = 0, 0, 0
        for loc in range(len(nums) - 1):
            max_loc = max(max_loc, loc + nums[loc])
            if loc == cur_end:
                jmp += 1
                cur_end = max_loc
        return jmp

Solution().jump([3,4,1,1,2,3,1,2,5])