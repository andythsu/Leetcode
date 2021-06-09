class Solution {
    public String minWindow(String s, String t) {
        int[] charCount = new int[128];
        
        for(char c : t.toCharArray()) charCount[c]++;
        
        
        int count = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
        
        for(int right=0; right<s.length(); right++){
            charCount[s.charAt(right)]--;
            if(charCount[s.charAt(right)] >= 0) count++;
            while(count == t.length()){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    result = s.substring(left, left + minLen);
                }
                charCount[s.charAt(left)]++;
                if(charCount[s.charAt(left)] > 0) count--;
                left++;
            }
        }
        return result;
    }
}