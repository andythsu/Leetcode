class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqs = new HashMap();
        for(char c : s.toCharArray()) freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for(char c : freqs.keySet()){
            int freq = freqs.get(c);
            if(buckets[freq] == null) buckets[freq] = new ArrayList();
            buckets[freq].add(c);
        }
        
        StringBuilder rtn = new StringBuilder();
        for(int i=buckets.length - 1; i>=0; i--){
            List<Character> list = buckets[i];
            if(buckets[i] != null){
                for(char c : list){
                    for(int j=0; j<i; j++){
                        rtn.append(c);
                    }
                }
            }
        }
        
        return rtn.toString();
        
    }
}