class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(complement.containsKey(nums[i])){
                return new int[]{complement.get(nums[i]), i};
            }else{
                complement.put(diff, i);
            }
        }
        return new int[]{};
    }
}
