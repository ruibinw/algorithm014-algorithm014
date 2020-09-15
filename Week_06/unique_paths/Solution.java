package unique_paths;

/**
 * 递归
 * Time：O(2^(mn))
 * Space：O(m + n）
 */
class Solution1 {
    public int uniquePaths(int m, int n) {
        return (m == 1 && n == 1) ? 1 :
                (m == 1) ? uniquePaths(m, n - 1) :
                        (n == 1) ? uniquePaths(m - 1, n) :
                                uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}

/**
 * 递归 + 缓存
 * Time：O(mn)
 * Space：O(m + n）
 */
class Solution2 {
    public int uniquePaths(int m, int n) {
        return uniquePaths(m - 1, n - 1, new int[m][n]);
    }

    private int uniquePaths(int m, int n, int[][] cache) {
        if (m == 0 && n == 0)
            return 1;

        if (cache[m][n] > 0)
            return cache[m][n];

        cache[m][n] = (m == 0) ? uniquePaths(m, n - 1, cache) :
                (n == 0) ? uniquePaths(m - 1, n, cache) :
                        uniquePaths(m - 1, n, cache) + uniquePaths(m, n - 1, cache);

        return cache[m][n];
    }
}

/**
 * 动态规划
 * Time：O(mn)
 * Space：O(mn）
 */
class Solution3 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

/**
 * 动态规划，优化空间复杂度
 * Time：O(mn)
 * Space：O(n）
 */
class Solution4 {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) cur[i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
