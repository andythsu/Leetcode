class Solution {
    int count = 0;
    public int combinationSum4(int[] nums, int t) {
        return dp(nums, t);
        // backtracking(nums, t, 0);
        // return count;
    }
    // time limit exceed
    public void backtracking(int[] nums, int t, int currentSum){
        if(currentSum > t) return;
        if(currentSum == t){
            count++;
            return;
        }
        for(int i=0; i<nums.length; i++){
            backtracking(nums, t, currentSum + nums[i]);
        }
    }
    public int dp(int[] nums, int t){
        int[] table = new int[t+1];
        table[0] = 1;
        for(int i=1; i <= t; i++){
            for(int j=0; j<nums.length; j++){
                if(i >= nums[j]) table[i] += table[i - nums[j]];
            }
        }
        return table[t];
    }
}