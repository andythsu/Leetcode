class Solution {
    int BASE = 26;
    int MOD = 10000007;
    public int strStr(String haystack, String needle) {
        
        int hLength = haystack.length();
        int nLength = needle.length();
        
        if(nLength == 0) return 0;
        
        long target = 0;
        long pow = 1;
        for(int i=0; i<nLength; i++){
            
            // % MOD to avoid overflow
            target = (target * BASE + needle.charAt(i)) % MOD;
            
            // calculate the significant number
            pow = pow * BASE % MOD;
        }
        
        long curHash = 0;
        for(int i=0; i<hLength; i++){
            curHash = (curHash * BASE + haystack.charAt(i)) % MOD;
            // slide the window
            if(i >= nLength){
                curHash = ((curHash - haystack.charAt(i - nLength) * pow % MOD) + MOD) % MOD;
            }
            if(curHash == target){
                return i - nLength + 1;
            }
        }
        
        return -1;
        
    }
}