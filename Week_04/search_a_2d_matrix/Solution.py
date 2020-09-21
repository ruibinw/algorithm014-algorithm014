class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0]) if m > 0 else 0

        lo, hi = 0, m * n - 1
        while lo <= hi:
            mid = int((lo + hi) / 2)
            val = matrix[int(mid / n)][mid % n]
            if val == target:
                return True
            if val < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return False