class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()) freq[c]++;
        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}