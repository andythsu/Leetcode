class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()];
        for(int i=0; i<s.length(); i++){
            for(int j=i; j>=0; j--){
                String str = s.substring(j, i+1);
                if(set.contains(str)){
                    if(j == 0 || dp[j-1]){
                        dp[i] = true;
                        break;
                    }
                }
                dp[i] = false;
            }
        }
        return dp[s.length()-1];
    }
}