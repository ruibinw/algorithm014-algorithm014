class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0]) if obstacleGrid else 0
        dp = [0] * n
        dp[0] = 1
        for row in obstacleGrid:
            for i in range(n):
                if row[i] == 1:
                    dp[i] = 0
                elif i > 0:
                    dp[i] += dp[i - 1]
        return dp[n - 1]