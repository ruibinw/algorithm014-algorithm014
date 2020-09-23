class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m < n:
            return self.uniquePaths(n, m);
        dp = [1] * n
        for _ in range(1, m):
            for i in range(1, n):
                dp[i] += dp[i - 1]
        return dp[-1]