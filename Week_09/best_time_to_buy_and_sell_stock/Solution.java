package best_time_to_buy_and_sell_stock;

/**
 * 优化暴力法 O(n), O(1)
 */
class Solution1 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}

/**
 * 动态规划 O(n), O(1)
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int curmax = 0, maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            //when the cum profit gain (curmax + (prices[i] - prices[i-1])) falls below 0, reset curmax to 0
            curmax = Math.max(curmax + (prices[i] - prices[i - 1]), 0);
            //record the maxprofit found so far
            maxprofit = Math.max(maxprofit, curmax);
        }
        return maxprofit;
    }
}
