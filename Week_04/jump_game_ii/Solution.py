from typing import List

# 贪心法
class Solution1:
    def jump(self, nums: List[int]) -> int:
        jmp, cur_end, max_loc = 0, 0, 0
        for loc in range(len(nums) - 1):
            max_loc = max(max_loc, loc + nums[loc])
            if loc == cur_end:
                jmp += 1
                cur_end = max_loc
        return jmp


# 贪心法，优化代码：
# 1.添加跳不到最后的情况，返回 -1
# 2.遇到能跳到最后的情况 max_loc >= endpoint，直接返回，不用继续循环到 endpoint
class Solution2:
    def jump(self, nums: List[int]) -> int:
        last = len(nums) - 1
        if last == 0: return 0

        jmp, cur_end = 0, 0
        loc, max_loc = 0, 0
        while loc <= max_loc:
            max_loc = max(max_loc, loc + nums[loc])
            if max_loc >= last:
                return jmp + 1
            if loc == cur_end:
                jmp += 1
                cur_end = max_loc
            loc += 1
        return -1
