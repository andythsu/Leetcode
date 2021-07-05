class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Set<String> set = new HashSet();
        
        for(String s : words) set.add(s);
        
        Set<String> setCopy = new HashSet(set);
        
        Iterator<String> setIterator = set.iterator();
        
        List<String> list = new ArrayList();
                
        while(setIterator.hasNext()){
            String word = setIterator.next();
            setCopy.remove(word);
            if(helper(word, setCopy)) list.add(word);
            setCopy.add(word);
        }
        
        return list;
        
    }
    
    private boolean helper(String word, Set<String> set){
        if(word.length() == 0) return false;
        boolean[] dp = new boolean[word.length()];
        for(int i=word.length() - 1; i >= 0; i--){
            for(int j=i; j < word.length(); j++){
                String w = word.substring(i, j+1);
                if(set.contains(w)){
                    if(j == word.length() - 1 || dp[j+1]){
                        dp[i] = true;
                        continue;
                    }
                }
                
            }
        }
        return dp[0];
    }
}