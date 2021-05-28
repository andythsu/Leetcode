class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(target < nums[left] + nums[right]){
                right--;
            }else if (target > nums[left] + nums[right]){
                left++;
            }else{
                return new int[]{left+1, right+1};
            }
        }
        return ans;
    }
}