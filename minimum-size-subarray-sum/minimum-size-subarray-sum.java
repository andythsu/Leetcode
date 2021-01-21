class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int rollingSum = 0;
        int result = Integer.MAX_VALUE;
        int left = 0;
        for(int i=0; i<nums.length; i++){
            rollingSum += nums[i];
            while(rollingSum >= s){
                result = Math.min(result, i-left+1);
                rollingSum -= nums[left];
                left++;
            }
        }
        return result != Integer.MAX_VALUE ? result : 0;
    }
}
