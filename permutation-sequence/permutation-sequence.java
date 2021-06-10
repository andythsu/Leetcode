/**
https://www.youtube.com/watch?v=W9SIlE2jhBQ
*/
class Solution {
    public String getPermutation(int n, int k) {
        // get permutations
        List<Integer> avail = new ArrayList();
        int[] fact = new int[10];
        fact[0] = 1;
        for(int i=1; i<=9; i++) fact[i] = fact[i-1] * i; 
        
        // put all avail numbers in list
        for(int i=1; i<=n; i++) avail.add(i);
        
        String ans = "";
        while(true){
            if(avail.size() == 1){
                return ans + avail.get(0);
            }
            int index = (k-1) / fact[n-1]; // k-1 because our groups are 0-based
            ans = ans + avail.get(index) + "";
            avail.remove(index);
            k = k - index * fact[n-1];
            n = n - 1;
        }
    }
}
