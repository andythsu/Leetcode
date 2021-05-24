class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[left] <= nums[mid]){
                if(nums[mid] < nums[right]){
                    // entire array is sorted
                    ans = Math.min(ans, nums[left]);
                    right = mid - 1;
                }else{
                    // left half is sorted, find right half minimum
                    ans = Math.min(ans, nums[left]);
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < nums[right]){
                    ans = Math.min(ans, nums[right]);
                    right = mid;
                }else{
                    ans = Math.min(ans, nums[right]);
                    left = mid + 1;
                }
            }
        }
        return ans;
    }
}