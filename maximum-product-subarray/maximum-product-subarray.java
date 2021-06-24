class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int preMax = 1;
        int preMin = 1;
        int currentMax;
        int currentMin;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int tempMax = preMax * nums[i];
            int tempMin = preMin * nums[i];
            
            currentMax = Math.max(tempMax, tempMin);
            currentMin = Math.min(tempMax, tempMin);
            
            preMax = Math.max(currentMax, nums[i]);
            preMin = Math.min(currentMin, nums[i]);
            
            maxSum = Math.max(maxSum, preMax);
        }
        return maxSum;
    }
}