class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() || (s == "" && t == "")) return "";
        int[] charCount = new int[128];
        
        for(char c : t.toCharArray()) charCount[c]++;
        
        int count = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        
        for(int right=0; right<s.length(); right++){
            char cur = s.charAt(right);
            charCount[cur]--;
            if(charCount[cur] >= 0) count++;
            while(count == t.length()){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    res = s.substring(left, right+1);
                }
                charCount[s.charAt(left)]++;
                if(charCount[s.charAt(left)] > 0) count--;
                left++;
            }
        }
        return res;
    }
}