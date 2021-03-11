class Solution {
    public int countVowelStrings(int n) {
        // recursive
        return helper(n, 0);
    }
    public int helper(int n, int start){
        if(n == 0) return 1;
        int res = 0;
        for(int i=start; i<5; i++){
            res += helper(n-1, i);
        }
        return res;
    }
}