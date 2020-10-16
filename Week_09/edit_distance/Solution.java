package edit_distance;

/**
 * dfs
 */
class Solution1 {
    private String word1, word2;
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.memo = new int[word1.length()][word2.length()];
        return minDistance(word1.length() - 1, word2.length() - 1);
    }

    private int minDistance(int i, int j) {
        if (i < 0 || j < 0)
            return i + j + 2; //(i + 1) + (j + 1)

        if (word1.charAt(i) == word2.charAt(j))
            return minDistance(i - 1, j - 1);

        if (memo[i][j] != 0)
            return memo[i][j];

        int replace = 1 + minDistance(i - 1, j - 1);
        int insert = 1 + minDistance(i - 1, j);
        int delete = 1 + minDistance(i, j - 1);
        memo[i][j] = Math.min(replace, Math.min(insert, delete));
        return memo[i][j];
    }
}

/**
 * 动态规划
 */
class Solution2 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
