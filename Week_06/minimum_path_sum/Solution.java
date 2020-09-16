package minimum_path_sum;

/**
 * 递归 + 缓存
 * 要走到当前格子只有两种可能，要么从上边的格子走下来，要么是从左边格子走过来
 * 所以，当前格子的最小路径和 = 当前格子的值 + min(上边，左边的最小路径和)
 * Time: O(mn)
 * Space: O(m + n)
 */
class Solution1 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return dfsMinPathSum(grid, m - 1, n - 1, new int[m][n]);
    }

    private int dfsMinPathSum(int[][] grid, int i, int j, int[][] cache) {
        if (cache[i][j] > 0)
            return cache[i][j];

        cache[i][j] = (i == 0 && j == 0) ? grid[0][0] :
                (i == 0) ? grid[i][j] + dfsMinPathSum(grid, 0, j - 1, cache) :
                        (j == 0) ? grid[i][j] + dfsMinPathSum(grid, i - 1, 0, cache) :
                                grid[i][j] + Math.min(dfsMinPathSum(grid, i - 1, j, cache), dfsMinPathSum(grid, i, j - 1, cache));

        return cache[i][j];
    }
}

/**
 * 动态规划，使用二维数组保存状态
 * Time: O(mn)
 * Space: O(mn)
 */
class Solution2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}

/**
 * 动态规划，使用一维数组保存状态
 * Time: O(mn)
 * Space: O(n)
 */
class Solution3 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dp[j] += grid[i][j];
                else if (i == 0)
                    dp[j] = grid[i][j] + dp[j - 1];
                else
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[n - 1];
    }
}
