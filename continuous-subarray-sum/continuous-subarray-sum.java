class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            sum = sum % k;
            
            if(map.containsKey(sum)){
                if(i - map.get(sum) >= 2) return true;
            }else{
                map.put(sum, i);
            }
            
        }
        
        if(sum % k == 0) return true;
        
        return false;
    }
}