class Solution {
    public char findTheDifference(String s, String t) {
        if(s == "") return t.charAt(0);
        int sum = 0;
        for(int i=0; i<t.toCharArray().length; i++){
            char c = t.charAt(i);
            sum += c;
        }
        for(int i=0; i<s.toCharArray().length; i++){
            char c = s.charAt(i);
            sum -= c;
        }
        return (char)sum;
    }
}