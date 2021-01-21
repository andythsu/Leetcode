/*
this question is equivalent to finding the longest subarray that add up to totalSum - x
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int i=0; i<nums.length; i++) totalSum += nums[i];
        int remaining = totalSum - x;
        if(remaining < 0) return -1; // no way to reduce x to 0
        if(remaining == 0) return nums.length; // entire array add up to x
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while(j < nums.length){
            sum += nums[j];
            while(sum >= remaining){
                if(sum == remaining) max = Math.max(max, j - i + 1);
                sum -= nums[i];
                i++;   
            }
            j++;
        }
        return max == Integer.MIN_VALUE ? -1 : nums.length - max;
    }
}
