class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        min_path = [0] * (len(triangle[-1]) + 1)
        for row in triangle[::-1]:
            for i in range(len(row)):
                min_path[i] = min(min_path[i], min_path[i + 1]) + row[i]
        return min_path[0]