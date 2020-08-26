from typing import List


class Solution1:
    def rotate(self, nums: List[int], k: int) -> None:
        for _ in range(k):
            last_num = nums[-1]
            for i in reversed(range(1, len(nums))):
                nums[i] = nums[i - 1]
            nums[0] = last_num


class Solution2:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k = k % n
        count = 0
        start = 0
        while count < n:
            cur = start
            prev_num = nums[start]
            while True:
                next = (cur + k) % n
                temp = nums[next]
                nums[next] = prev_num
                prev_num = temp
                cur = next
                count += 1
                if start == cur: break
            start += 1


class Solution3:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k %= n
        def reverse(start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start, end = start + 1, end - 1
        reverse(0, n - 1)
        reverse(0, k - 1)
        reverse(k, n - 1)
        # 切片操作，更简洁，但是不是原地操作，等号右边的两个切片操作创建了两个新新数组
        # nums[:] = nums[-k:] + nums[:-k]
