class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // detect if graph has cycle. It is impossible to finish if there is a cycle in this graph
        ArrayList[] graph = new ArrayList[numCourses];
        
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<Integer>();
        
        // build graph
        for(int[] i : prerequisites) graph[i[1]].add(i[0]);

        Set<Integer> whiteSet = new HashSet();
        Set<Integer> graySet = new HashSet();
        Set<Integer> blackSet = new HashSet();
        
        for(int i=0; i<numCourses; i++) whiteSet.add(i);
        
        
        while(!whiteSet.isEmpty()){
            int current = whiteSet.iterator().next();
            if(dfs(current, whiteSet, graySet, blackSet, graph)){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int current, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet, ArrayList[] graph){
        
        moveToSet(current, whiteSet, graySet);
        ArrayList<Integer> neighbors = graph[current];
        
        for(int i=0; i<neighbors.size(); i++){
            int neighbor = neighbors.get(i);
            
            if(blackSet.contains(neighbor)) continue;
            
            if(graySet.contains(neighbor)) return true;
            
            if(dfs(neighbor, whiteSet, graySet, blackSet, graph)) return true;
        }
        
        moveToSet(current, graySet, blackSet);
        return false;        
    }
    
    public void moveToSet(int target, Set<Integer> from, Set<Integer> to){
        from.remove(target);
        to.add(target);
    }
}