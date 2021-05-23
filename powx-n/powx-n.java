class Solution {
    public double myPow(double x, int n) {
        if(n == 1) return x;
        if(n == 0) return 1;
        if(n == -1) return 1/x;
        
        int mid = n / 2;
        
        // if n is even
        if(n % 2 == 0){
            double ans = myPow(x, mid);
            return ans * ans;
        }else{
            double ans = myPow(x, mid);
            return ans * ans * myPow(x, n - mid * 2);
        }
    }
}