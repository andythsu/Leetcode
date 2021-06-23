class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        int MAX_BOUND = 46340;
        for(int i=1; i<=MAX_BOUND; i++){
            if(i * i > x) return i-1;
        }
        return MAX_BOUND;
    }
}