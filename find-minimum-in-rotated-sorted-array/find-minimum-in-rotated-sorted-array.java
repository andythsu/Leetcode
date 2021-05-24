class Solution {
    public int findMin(int[] nums) {
        return solution2(nums);
    }
    public int solution2(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        if(nums.length == 1) return nums[0];
        // if entire array is sorted
        if(nums[0] < nums[nums.length - 1]) return nums[0];
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if(nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int solution1(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[left] <= nums[mid]){
                if(nums[mid] < nums[right]){
                    // entire array is sorted
                    ans = Math.min(ans, nums[left]);
                    right = mid;
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