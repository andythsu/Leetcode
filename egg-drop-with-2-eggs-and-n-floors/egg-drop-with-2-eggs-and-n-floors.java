class Solution {
    public int twoEggDrop(int n) {
        return solution2(n);
        
    }
    public int solution1(int n){
        return (int) Math.ceil((Math.sqrt(1 + 8 * n) - 1) / 2);
    }
    public int solution2(int n){
        int eggs = 2;
        return helper(n, eggs, new int[n+1][eggs+1]);
    }
    public int helper(int floor, int eggs, int[][] dp){
        if(floor <= 1 || eggs == 1) return floor;
        if(dp[floor][eggs] > 0) return dp[floor][eggs];
        int min = Integer.MAX_VALUE;
        for(int f = 1; f <= floor; f++){
            min = Math.min(min, 1 + Math.max(helper(f-1, eggs-1, dp), helper(floor - f, eggs, dp)));
        }
        dp[floor][eggs] = min;
        return min;
    }
}