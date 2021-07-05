class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap();
        Map<String, String> lookup = new HashMap();
        
        for(String s : strs){
            String encode = encodeStr(s);
            if(!lookup.containsKey(encode)){
                lookup.put(encode, s);
            }
            String key = lookup.get(encode);
            List<String> buckets = map.getOrDefault(key, new ArrayList());
            buckets.add(s);
            map.put(key, buckets);
        }
        
        List<List<String>> list = new ArrayList();
        
        for(String s : map.keySet()){
            list.add(map.get(s));
        }
        
        return list;
        
    }
    
    private String encodeStr(String str){
        int[] count = new int[128];
        StringBuilder encode = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            count[str.charAt(i)]++;
        }
        
        for(int i=0; i<count.length; i++){
            if(count[i] != 0){
                encode.append(count[i]);
                encode.append((char)i);
            }
        }
        return encode.toString();
    }
}