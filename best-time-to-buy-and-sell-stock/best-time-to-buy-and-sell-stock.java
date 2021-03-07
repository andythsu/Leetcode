class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int cur_min = prices[0];
        int cur_max = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] < cur_min){
                cur_min = prices[i];
                cur_max = prices[i];
            }else{
                if(prices[i] > cur_max){
                    cur_max = prices[i];
                    profit = Math.max(profit, cur_max - cur_min); 
                }
            }
        }
        return profit;
    }
}