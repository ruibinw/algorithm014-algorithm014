package longest_common_subsequence;

/**
 * 递归
 * Time: O(...)
 * Space: O(...)
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
 * 动态规划：二维数组
 * Time: O(mn)
 * Space: O(mn)
 */
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}

/**
 * 动态规划：优化空间复杂度，一维数组
 * Time: O(mn)
 * Space: O(min(m, n))
 */
class Solution3 {
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
