package best_time_to_buy_and_sell_stock_iii;

class Solution {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE, oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE, twoBuyTwoSell = 0;
        for (int price : prices) {
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + price);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - price);
            oneBuyOneSell = Math.max(oneBuyOneSell, oneBuy + price);
            oneBuy = Math.max(oneBuy, -price);
        }
        return twoBuyTwoSell;
    }
}
