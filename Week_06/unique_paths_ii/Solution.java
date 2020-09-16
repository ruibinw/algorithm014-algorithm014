package unique_paths_ii;

/**
 * 递归 + 缓存
 * Time: O(mn)
 * Space: O(m + n)
 */
class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return uniquePaths(obstacleGrid, new int[m][n], m - 1, n - 1);
    }

    private int uniquePaths(int[][] obstacleGrid, int[][] cache, int i, int j) {
        if (i == 0 && j == 0)
            return obstacleGrid[0][0] == 1 ? 0 : 1;

        if (cache[i][j] > 0)
            return cache[i][j];

        cache[i][j] = obstacleGrid[i][j] == 1 ? 0 :
                            i == 0 ? uniquePaths(obstacleGrid, cache, i, j - 1) :
                                    j == 0 ? uniquePaths(obstacleGrid, cache, i - 1, j) :
                                            uniquePaths(obstacleGrid, cache, i - 1, j) + uniquePaths(obstacleGrid, cache, i, j - 1);

        return cache[i][j];
    }
}

/**
 * 动态规划
 * Time: O(mn)
 * Space: O(n)
 */
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < n; i++) {
                if (row[i] == 1)
                    dp[i] = 0;
                if (i > 0 && row[i] == 0)
                    dp[i] += dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
