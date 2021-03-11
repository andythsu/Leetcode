class Solution {
    public int countVowelStrings(int n) {
        // recursive
        // return helper(n, 0);
        // dp
        return dp(n);
    }
    public int dp(int n){
        int[][] table = new int[n][5];
        Arrays.fill(table[0], 1);
        int res = 0;
        
        for(int i = 1; i < table.length; i++){
            for(int j=4; j>=0; j--){
                table[i][j] = j == 4 ? 1 : table[i-1][j] + table[i][j+1];
            }
        }
        
        for(int j = 0; j<5; j++){
            res += table[n-1][j];
        }
        return res;
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