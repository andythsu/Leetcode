class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int cost = -prices[0];
        for(int i=1; i<prices.length; i++){
            profit = Math.max(profit, cost + prices[i] - fee); // do nothing vs sell one today
            cost = Math.max(cost, profit - prices[i]); // do nothing vs buy one today
        }
        return profit;
    }
}
