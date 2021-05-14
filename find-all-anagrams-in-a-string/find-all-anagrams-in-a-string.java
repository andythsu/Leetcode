class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] occur = new int[26];
        for(char c : p.toCharArray()){
            occur[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        while(right < s.length()){
            char curChar = s.charAt(right);
            if(occur[curChar - 'a'] > 0){
                count--;
            }
            occur[curChar - 'a']--;            
            right++;
            if(count == 0) result.add(left);
            if(right - left == p.length()){
                if(occur[s.charAt(left) - 'a'] >= 0){
                    count++;
                }
                occur[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }
}