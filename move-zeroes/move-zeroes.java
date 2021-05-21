class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }
        
        for(int i=zeroIndex; i < nums.length; i++){
            nums[i] = 0;
        }
        
    }
}