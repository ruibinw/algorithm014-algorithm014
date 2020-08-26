from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area, i, j = 0, 0, len(height) - 1
        while i < j:
            if height[i] < height[j]:
                max_area = max(max_area, (j - i) * height[i])
                i += 1
            else:
                max_area = max(max_area, (j - i) * height[j])
                j -= 1
        return max_area