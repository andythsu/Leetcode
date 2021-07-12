class KthLargest {
    
    PriorityQueue<Integer> pq;
    int cap;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue();    
        cap = k;
        for(int n : nums) add(n);
    }
    
    public int add(int val) {
        if(pq.size() < cap){
            pq.add(val);        
        }else{
            if(pq.peek() < val){
                pq.add(val);
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */