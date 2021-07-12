class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet(Arrays.asList(banned));
        String ans = "";
        Map<String, Integer> occur = new HashMap();
        
        int startIndex = 0;
        int i = 0;
        while(i < paragraph.length()){
            while(i < paragraph.length() && isLetter(paragraph.charAt(i))){
               i++; 
            }
            
            String substr = paragraph.substring(startIndex, i).toLowerCase();
            occur.put(substr, occur.getOrDefault(substr, 0) + 1);
            
            while(i < paragraph.length() && !isLetter(paragraph.charAt(i))){
                i++;
            }
            
            startIndex = i;
        }
        
        System.out.println(occur);
        
        int max = 0;
        for(String s : occur.keySet()){
            if(set.contains(s)){
                occur.put(s, 0);
            }
            if(occur.get(s) > max){
                max = occur.get(s);
                ans = s;
            }
        }
        
        return ans;
    }
    
    private boolean isLetter(char c){
        return Character.isLetter(c);
    }
}