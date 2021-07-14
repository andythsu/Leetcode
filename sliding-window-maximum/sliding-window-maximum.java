class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> q = new ArrayDeque();
        
        int[] ans = new int[nums.length - k + 1];
        
        for(int i=0, j=0; i<nums.length; i++){
            // maintaining window
            while(!q.isEmpty() && q.peek() <= i-k){
                q.poll();
            }
            
            // maintain elements in des order
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.pollLast();
            }
            
            q.addLast(i);
            
            // if we have a window
            if(i >= k-1){
                ans[j] = nums[q.peekFirst()];
                j++;
            }
        }
        return ans;
    }
}