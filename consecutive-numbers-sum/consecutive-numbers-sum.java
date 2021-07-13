class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 1;
        if(n == 1) return ans;
        for(int i=2; (i+1)*i/2 <= n; i++){
            int sum = (i+1)*i/2;
            
            int diff = n - sum;
            
            // if difference can be divided by i, we can increment i by (diff % i) to reach n
            if(diff % i == 0) ans++;
        }
        return ans;
    }
}