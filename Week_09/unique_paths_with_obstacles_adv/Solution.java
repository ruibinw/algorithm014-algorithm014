package unique_paths_with_obstacles_adv;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int[] grid : obstacleGrid) {
            for (int i = 0; i < n; i++) {
                if (grid[i] == 1)
                    dp[i] = 0;
                else if (i > 0)
                    dp[i] = dp[i - 1] + dp[i];
            }
        }
        return dp[n - 1];
    }
}
