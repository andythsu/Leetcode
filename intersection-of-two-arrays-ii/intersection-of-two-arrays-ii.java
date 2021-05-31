class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Occur = new HashMap();
        for(int num : nums1){
            nums1Occur.put(num, nums1Occur.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(nums1Occur.containsKey(num) && nums1Occur.get(num) > 0){
                list.add(num);
                nums1Occur.put(num, nums1Occur.get(num) - 1);
            }
        }
        
        // convert to int[]
        int[] rtn = new int[list.size()];
        for(int i=0; i<rtn.length; i++){
            rtn[i] = list.get(i);
        }
        return rtn;
    }
}