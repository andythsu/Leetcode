class Solution {
    public int maxProfit(int[] prices) {
        // https://www.youtube.com/watch?v=oDhu5uGq_ic
        int transaction = 2;
        int[][] dp = new int[transaction+1][prices.length];
        for(int i = 1; i<dp.length; i++){
            int maxDiff = -prices[0];
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i-1][j] - prices[j]);
            }
        }
        return dp[transaction][prices.length - 1];
    }
}