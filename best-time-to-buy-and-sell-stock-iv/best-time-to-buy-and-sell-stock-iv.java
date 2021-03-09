class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 0) return 0;
        // dp_ij = transaction i on day j
        int[][] dp = new int[k+1][prices.length];
        for(int i = 1; i<dp.length; i++){
            int maxDiff = -prices[0];
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = Math.max(dp[i][j-1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, dp[i-1][j] - prices[j]);
            }
        }   
        return dp[k][prices.length - 1];
    }
}