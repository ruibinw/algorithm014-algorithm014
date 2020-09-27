package longest_common_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归
 * Time: O(2^mn), 最坏情况都要往两个分支走下去
 * Space: O(m + n)
 */
class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, text1.length() - 1,  text2.length() - 1);
    }

    private int dfs(String text1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (text1.charAt(i) == s2.charAt(j))
            return dfs(text1, s2, i - 1,  j - 1) + 1;
        else
            return Math.max(dfs(text1, s2, i - 1, j), dfs(text1, s2, i, j - 1));
    }
}

/**
 * dfs + 记忆化
 */
class Solution2{
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, text1.length() - 1, text2.length() - 1, new HashMap<>());
    }
    private int dfs(String s1, String s2, int m, int n, Map<String, Integer> memo) {
        if (m < 0 || n < 0)
            return 0;

        String key = m + "," + n;
        if (memo.get(key) != null)
            return memo.get(key);

        int count = s1.charAt(m) == s2.charAt(n) ?
                    dfs(s1, s2, m - 1, n - 1, memo) + 1 :
                    Math.max(dfs(s1, s2, m, n - 1, memo), dfs(s1, s2, m - 1, n, memo));

        memo.put(key, count);
        return count;
    }
}

/**
 * 动态规划：二维数组
 * Time: O(mn)
 * Space: O(mn)
 */
class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}

/**
 * 动态规划：优化空间复杂度，一维数组
 * Time: O(mn)
 * Space: O(min(m, n))
 */
class Solution4 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m < n) return longestCommonSubsequence(text2, text1);

        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int preRow = 0;
            for (int j = 1; j <= n; j++) {
                int preRowPreCol = preRow;
                preRow = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = preRowPreCol + 1;
                }
                else {
                    dp[j] = Math.max(dp[j - 1], preRow);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestCommonSubsequence("abcde", "ace"));//3
        System.out.println(new Solution1().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));//1
        System.out.println(new Solution1().longestCommonSubsequence("abcba", "abcbcba"));//5
    }
}
