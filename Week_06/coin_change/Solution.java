package coin_change;

import java.util.*;

/**
 * DFS
 * Time: O(...)，n = 硬币个数, k 是递归树的深度 = amount/min(coins)
 * Space: O(k)
 */
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;
            int count = coinChange(coins, amount - coin);
            if (count != -1) minCoins = Math.min(minCoins, count + 1);
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}

/**
 * DFS + 缓存
 * Time: O(k)，k 是递归树的深度 = amount/min(coins)
 * Space: O(k)
 */
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        return dfs(coins, amount, new HashMap<>());
    }

    private int dfs(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }
        if (memo.get(amount) != null) {
            return memo.get(amount);
        }
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;

            int coinCount = dfs(coins, amount - coin, memo);
            if (coinCount >= 0) minCoins = Math.min(minCoins, coinCount + 1);
        }
        minCoins = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        memo.put(amount, minCoins);
        return minCoins;
    }
}

/**
 * BFS, 将问题处理成 图 上的 最短路径
 */
class Solution3 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(amount);
        visited.add(amount);

        Arrays.sort(coins);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                amount = queue.poll();
                //实现剪枝：面值大的硬币用的足够多，这个组合的硬币个数肯定是最小
                //通过排序后，从最大面值开始尝试，更快的找到最小硬币组合
                for (int j = coins.length - 1; j >= 0; j--) {
                    int remain = amount - coins[j];
                    if (remain == 0) return count;
                    if (remain < 0) continue;
                    if (!visited.contains(remain)) {
                        queue.add(remain);
                        visited.add(remain);
                    }
                }
            }
        }
        return -1;
    }
}

/**
 * 动态规划
 */
class Solution4 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
