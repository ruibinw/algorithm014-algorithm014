package house_robber;

/**
 * 动态规划，二维数组
 */
class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return n == 0 ? 0 : nums[0];

        int[][] dp = new int[n][2];//0 不偷当前房屋，1 偷当前房屋
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); //不偷
            dp[i][1] = dp[i - 1][0] + nums[i];               //偷
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}

/**
 * 动态规划，一维数组
 */
class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return n == 0 ? 0 : nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}

/**
 * 动态规划，常量复杂度
 */
class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return n == 0 ? 0 : nums[0];

        int pre = 0, cur = 0;
        for (int num : nums) {
            int tmp = cur;
            cur = Math.max(cur, pre + num);
            pre = tmp;
        }
        return cur;
    }
}


