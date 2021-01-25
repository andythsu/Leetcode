class Solution {
    // starting from the back, if we can reach it from i+nums[i], then we update lastIndex
    public boolean canJump(int[] nums) {
        int lastIndex = 0;
        for(int i = nums.length - 1; i>=0; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}
