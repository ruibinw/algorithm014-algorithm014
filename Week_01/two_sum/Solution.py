from typing import List


class Solution1:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        for i in range(n - 1):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return None


class Solution2:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i, num in enumerate(nums):
            x = target - num;
            if x in map:
                return [map[x], i]
            map[num] = i


m = {1:5, 2:2, 3:3}
if 1 in m: print(m[1])