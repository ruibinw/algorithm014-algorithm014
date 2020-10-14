package minimum_path_sum_adv;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dp[j] = grid[i][j] + dp[j];
                else if (i == 0)
                    dp[j] = grid[i][j] + dp[j - 1];
                else
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[n - 1];
    }
}
