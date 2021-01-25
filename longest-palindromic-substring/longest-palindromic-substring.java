class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 0) return "";
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = getLength(i, i, s);
            int len2 = getLength(i, i+1, s);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + (len/2);
            }
        }
        return s.substring(start, end + 1);
    }
    public int getLength(int start, int end, String s){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
