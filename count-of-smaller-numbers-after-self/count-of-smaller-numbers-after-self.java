/* https://www.youtube.com/watch?v=ffbwCfJ2Qjw */
class Solution {
    class Item{
        int index;
        int val;
        public Item(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for(int i=0; i<n; i++){
            items[i] = new Item(i, nums[i]);
        }
        
        int[] count = new int[n];
        mergeSort(items, 0, n-1, count);
        List<Integer> res = new ArrayList();
        for(int c : count){
            res.add(c);
        }
        return res;
        
    }
    
    private void mergeSort(Item[] items, int lo, int hi, int[] count){
        if(lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        
        mergeSort(items, lo, mid, count);
        mergeSort(items, mid + 1, hi, count);
        
        merge(items, lo, mid, mid+1, hi, count);
    }
    
    private void merge(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count){
        int m = hiEnd - lo + 1;
        Item[] sorted = new Item[m];
        
        int index = 0;
        int loPtr = lo, hiPtr = hi;
        
        int rightCounter = 0;
        
        while(loPtr <= loEnd && hiPtr <= hiEnd){
            if(items[hiPtr].val < items[loPtr].val){
                rightCounter++;
                sorted[index] = items[hiPtr];
                index++;
                hiPtr++;
            }else{
                count[items[loPtr].index] += rightCounter;
                sorted[index] = items[loPtr];
                index++;
                loPtr++;
            }
        }
        
        while(loPtr <= loEnd){
            count[items[loPtr].index] += rightCounter;
            sorted[index] = items[loPtr];
            index++;
            loPtr++;
        }
        
        while(hiPtr <= hiEnd){
            sorted[index] = items[hiPtr];
            index++;
            hiPtr++;
        }
        
        System.arraycopy(sorted, 0, items, lo, m);
        
    }
}
