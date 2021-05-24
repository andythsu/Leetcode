class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length - 1] < target){
            return nums.length;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        if(nums[left] < target){
            return left + 1;
        }
        if (nums[left] > target){
            return left;
        }
        return -1;
    }
}