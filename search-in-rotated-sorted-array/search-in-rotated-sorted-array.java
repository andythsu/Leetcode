class Solution {
    public int search(int[] nums, int target) {
    //     int high = arr.length - 1;
    //     int low = 0;
    //     while(low <= high){
    //         int mid = low + (high - low) / 2;
    //         if(arr[mid] == target){
    //             return mid;
    //         }
    //         if(arr[low] < arr[mid]){
    //             if(arr[low] <= target && target < arr[mid]){
    //                 high = mid - 1;
    //             }else{
    //                 low = mid + 1;
    //             }
    //         }else{
    //             if(arr[mid] < target && target <= arr[high]){
    //                 low = mid + 1;
    //             }else{
    //                 high = mid - 1;
    //             }
    //         }
    //     }
    //     return -1;
    // }
        int n = nums.length;
        int low=0;
        int high=n-1;
        while(low<=high) {
            
            int mid= low + (high-low)/2;
            
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] <= nums[mid]) {
                
                if(nums[low] <= target && target < nums[mid]) {
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }
            else {
                
                if(nums[mid] < target && target <= nums[high]) {
