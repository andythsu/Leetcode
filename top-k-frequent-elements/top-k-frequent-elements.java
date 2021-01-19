class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return bucket(nums, k);   
    }
    public int[] bucket(int[] nums, int k){
        if(k == nums.length) return nums;
        Map<Integer, Integer> tally = new HashMap<>();
        // tally the frequency
        for(int n : nums){
            tally.put(n, tally.getOrDefault(n, 0) + 1);
        }
        // adds the value to its frequency bucket
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for(int n : tally.keySet()){
            int count = tally.get(n);
            if(list[count] == null) list[count] = new ArrayList<>();
            list[count].add(n);
        }
        // starts gathering from the end of frequency list
        List<Integer> result = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && result.size() < k; i--) {
            if(list[i] != null){
                result.addAll(list[i]);
            }
        }
        // convert list to int array
        int[] arr = new int[result.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
    
    public int[] heapify(int[] nums, int k){
        if(k == nums.length) return nums;
        Map<Integer, Integer> tally = new HashMap<>();
        // tally the frequency
        for(int n : nums){
            tally.put(n, tally.getOrDefault(n, 0) + 1);
        }
        // sort the tally so the lowest frequency appears first
