class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        first_zero_index = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[first_zero_index] = nums[first_zero_index], nums[i]
                first_zero_index += 1
