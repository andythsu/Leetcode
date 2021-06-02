class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // sort ascending order based on # soilders and row #
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
        );
        for(int i=0; i<mat.length; i++){
            pq.add(new int[]{i, countSoilders(mat[i])});
        }
        int count = 0;
        int[] res = new int[k];
        while(!pq.isEmpty() && count < res.length){
            res[count] = pq.poll()[0];
            count++;
        }
        return res;
    }
    public int countSoilders(int[] arr){
        int l = 0;
        int r = arr.length;
        while(l < r){
            int mid = l + (r - l)/2;
            if(arr[mid] == 0){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}