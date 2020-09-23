class Solution1:
    def rob(self, nums: List[int]) -> int:
        n = len(nums) if nums else 0
        if n < 2: return 0 if n == 0 else nums[0]

        # max_rob 状态表：保存偷到当前房子的最多钱
        max_rob = [nums[0], max(nums[0], nums[1])]
        for i in range(2, n):
            max_rob.append(max(max_rob[i - 1], max_rob[i - 2] + nums[i]))
        return max_rob[n - 1]


# optimize space
class Solution2:
    def rob(self, nums: List[int]) -> int:
        n = len(nums) if nums else 0
        if n < 2: return 0 if n == 0 else nums[0]

        pre, cur = 0, 0
        for num in nums:
            pre, cur = cur, max(cur, pre + num)

        return cur