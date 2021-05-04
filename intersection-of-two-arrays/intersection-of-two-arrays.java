class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> intersection = new HashSet<>();
        for(int n : nums1) set1.add(n);
        for(int n : nums2){
            if(set1.contains(n)) intersection.add(n);
        }
        int[] result = new int[intersection.size()];
        int index = 0;
        for(int n : intersection){
            result[index] = n;
            index++;
        }

        return result;
        
    }
}