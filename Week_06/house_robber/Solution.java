package house_robber;

/**
 * DFS
 */
class Solution1 {
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 1), rob(nums, i - 2) + nums[i]);
    }
}

/**
 * DFS + memo
 */
class Solution2 {
    public int rob(int[] nums) {
        return rob(nums, nums.length - 1, new int[nums.length]);
    }
    private int rob(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = Math.max(rob(nums, i - 1, memo), rob(nums, i - 2, memo) + nums[i]);
        return memo[i];
    }
}

/**
 * 动态规划，一维数组
 */
class Solution3 {
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
class Solution4 {
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


