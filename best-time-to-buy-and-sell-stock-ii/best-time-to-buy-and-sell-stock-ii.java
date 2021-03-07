class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int gain = 0;
        while(i < prices.length){
            // find local minimum
            while(i < prices.length - 1 && prices[i+1] < prices[i]) i++;
            int min = prices[i];
            // find local maximum
            while(i < prices.length - 1 && prices[i+1] > prices[i]) i++;
            gain += prices[i] - min;
            // avoid infinite loop
            i++;
        }
        return gain;
    }
}
