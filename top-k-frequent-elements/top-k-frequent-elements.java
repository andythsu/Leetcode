class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums;
        Map<Integer, Integer> tally = new HashMap<>();
        // tally the frequency
        for(int n : nums){
            tally.put(n, tally.getOrDefault(n, 0) + 1);
        }
        // sort the tally so the lowest frequency appears first
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> tally.get(n1) - tally.get(n2));
        for(int n: tally.keySet()){
            heap.add(n);
            // poll the lowest so we only keep the "top N"
            if(heap.size() > k) heap.poll();
        }
        int[] top = new int[k];
        for(int i = 0; i<top.length; i++){
            top[i] = heap.poll();
        }
        return top;
    }
}
