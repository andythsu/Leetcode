class Solution {
    public int leastInterval(char[] tasks, int n) {
        // get the frequency of each char
        int[] freq = new int[26];
        for(char t : tasks){
            freq[t - 'A']++;
        }
        // max groups is based on max frequency of a char
        int maxGroups = 0;
        for(int f : freq){
            maxGroups = Math.max(f, maxGroups);
        }
        // answer will be (maxgroups-1) * (n+1) + remainings
        int answer = (maxGroups - 1) * (n + 1);
        for(int f : freq){
            int remaining = f - (maxGroups - 1);
            answer += remaining > 0 ? remaining : 0;
        }
        return Math.max(answer, tasks.length);
    }
}