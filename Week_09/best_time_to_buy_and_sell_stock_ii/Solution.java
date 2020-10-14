package best_time_to_buy_and_sell_stock_ii;

/**
 * 贪心法
 * 每次都取最大利润
 * 如果第二天涨：第一天买，第二天卖，赚差价（prices[i] - prices[i - 1]）
 * 如果第二天跌：不买卖，利润为 0
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }
}
