class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] count = new int[128];
        // store frequency of each char
        for(char c : s.toCharArray()){
            System.out.println((int)c);
            count[c]++;
        }
        // if we find an even frequency, we can make a palindrome out of it. We divide it by 2 first to get the floor of the value, then multiply by 2 to get the actual result
        for(int f : count){
            result += f / 2 * 2;
            // if our current result is even number and we have an odd number of character, we can add that character in our palindrome because a palindrome can allow odd number of length
            if(result % 2 == 0 && f % 2 == 1) result += 1;
        }
        return result;
    }
}