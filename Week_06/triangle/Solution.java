package triangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 递归 dfs
 */
class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minPath(triangle, 0, 0, new HashMap<>());
    }

    private int minPath(List<List<Integer>> triangle, int i, int j, Map<String, Integer> memo) {
        if (i == triangle.size()) return 0;

        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        int minPath = Math.min(minPath(triangle, i + 1, j, memo), minPath(triangle, i + 1, j + 1, memo)) + triangle.get(i).get(j);
        memo.put(key, minPath);
        return minPath;
    }
}

/**
 * 动态规划，二维数组
 */
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i +1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

/**
 * 动态规划，一维数组
 */
class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
