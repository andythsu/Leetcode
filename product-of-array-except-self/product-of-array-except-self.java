class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] right = new int[nums.length];
        
        int prod = 1;
        
        for(int i=nums.length-1; i>=0; i--){
            right[i] = prod;
            prod = prod * nums[i];
        }
        
        int[] rtn = new int[nums.length];
        
        
        prod = 1;
        for(int i=0; i<rtn.length; i++){
            rtn[i] = right[i] * prod;
            prod = prod * nums[i];
        }
        
        return rtn;
        
    }
}