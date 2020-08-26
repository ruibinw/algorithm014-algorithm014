# 嵌套循环找到左右边界
class Solution1:
    def largest_rectangle_area(self, heights: List[int]) -> int:
        n = len(heights)
        max_area = 0

        for mid in range(n):

            left = mid
            while left > 0 and heights[left - 1] >= heights[mid]:
                left -= 1

            right = mid
            while right < n - 1 and heights[right + 1] >= heights[mid]:
                right += 1

            max_area = max(max_area, (right - left + 1) * heights[mid])

        return max_area


# 利用栈保存左边界
class Solution2:
    def largest_rectangle_area(self, heights: List[int]) -> int:
        n = len(heights)
        max_area = 0
        stack = []

        i = 0
        while i <= n:
            h = 0 if i == n else heights[i]
            if not stack or h >= heights[stack[-1]]:
                stack.append(i)
                i += 1
            else:
                cur = heights[stack.pop()]
                right = i - 1
                left = 0 if not stack else stack[-1] + 1
                width = right - left + 1
                max_area = max(max_area, cur * width)

        return max_area