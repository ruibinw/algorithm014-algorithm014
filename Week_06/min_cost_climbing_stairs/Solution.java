package min_cost_climbing_stairs;

/**
 * 递归 + 缓存
 */
class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        return dfs(cost.length, cost, new int[cost.length + 1]);
    }

    private int dfs(int i, int[] cost, int[] memo) {
        if (i <= 1) return 0;
        if (memo[i] > 0) return memo[i];

        //要跳到第 i 层，有两种可能：从 i-1 用力 cost[i-1] 跳上来，或者，从 i-2 用力 cost[i-2] 跳上来
        memo[i] = Math.min(dfs(i - 1, cost, memo) + cost[i - 1],
                            dfs(i - 2, cost, memo) + cost[i - 2]);
        return memo[i];
    }
}

/**
 * 动态规划
 */
class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        return minCost[cost.length];
    }
}

/**
 * 动态规划, 优化空间复杂度
 */
class Solution3 {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[3];
        for (int i = 2; i <= cost.length; i++) {
            minCost[2] = Math.min(minCost[1] + cost[i - 1], minCost[0] + cost[i - 2]);
            minCost[0] = minCost[1];
            minCost[1] = minCost[2];
        }
        return minCost[2];
    }
}
