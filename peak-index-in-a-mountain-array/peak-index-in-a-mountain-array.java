class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(mid == 0){
                return mid+1;
            }
            
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            
            if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}