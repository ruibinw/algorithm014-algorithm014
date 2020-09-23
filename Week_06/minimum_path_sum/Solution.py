class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid[0]) if grid else 0
        dp = [sys.maxsize] * n
        dp[0] = 0
        for row in grid:
            for i in range(n):
                if i == 0:
                    dp[i] += row[i]
                else:
                    dp[i] = min(dp[i], dp[i - 1]) + row[i]
        return dp[n - 1]