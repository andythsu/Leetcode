class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : cpdomains){
            String[] split = s.split("\\s+");
            int count = Integer.valueOf(split[0]);
            String[] domains = split[1].split("\\.");
            String curDomain = "";
            for(int i = domains.length - 1; i>=0; i--){
                curDomain = domains[i] + (i < domains.length - 1 ? "." : "") + curDomain;
                map.put(curDomain, map.getOrDefault(curDomain, 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for(String domain : map.keySet()){
            res.add(map.get(domain) + " " + domain);
        }
        return res;
    }
}
