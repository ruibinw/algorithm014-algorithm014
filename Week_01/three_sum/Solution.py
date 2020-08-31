# 排序 + 双重循环 + 双指针
# Time: O(n^2)
# Space: O(1)
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if nums is None and len(nums) < 3:
            return []

        n = len(nums)
        nums.sort()

        res = []
        for i in range(n - 2):
            if nums[i] > 0: break
            if i > 0 and nums[i] == nums[i - 1]: continue
            lo, hi = i + 1, n - 1
            while lo < hi:
                sum = nums[i] + nums[lo] + nums[hi]
                if sum == 0:
                    res.append([nums[i], nums[lo], nums[hi]])
                    while lo < hi and nums[lo + 1] == nums[lo]: lo += 1
                    while lo < hi and nums[hi - 1] == nums[hi]: hi -= 1
                    lo += 1
                    hi -= 1
                elif sum < 0: lo += 1
                elif sum > 0: hi -= 1

        return res
