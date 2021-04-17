class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 0) return new int[0][0];
        List<Pair> allIntervals = new ArrayList<>();
        for(int[] i : intervals){
            allIntervals.add(new Pair(i[0], i[1]));
        }   
        // sort ascending order
        Collections.sort(allIntervals, (a,b) -> (int)a.getKey() - (int)b.getKey());
                
        List<Pair> resultList = new ArrayList<>();
        Pair curInterval = allIntervals.get(0);
        Pair cur = new Pair(curInterval.getKey(),curInterval.getValue());
        
        for(int i=1; i<allIntervals.size(); i++){
            curInterval = allIntervals.get(i);
            int start = (int)curInterval.getKey();
            int end = (int)curInterval.getValue();
            if(overBound(start, (int)cur.getValue())){
                // start is overbound current end
                resultList.add(cur);
                cur = new Pair(start, end);
            }else{
                if(inBound(end, (int)cur.getKey(), (int)cur.getValue())){
                    // end is in bound current interval
                    continue;
                }else{ 
                    // end is overbound current end
                    cur = new Pair((int)cur.getKey(), end);
                }
            }
        }
        
        resultList.add(cur);
        int[][] result = new int[resultList.size()][2];
        for(int i=0; i<resultList.size(); i++){
            int[] interval = {(int)resultList.get(i).getKey(), (int)resultList.get(i).getValue()};
            result[i] = interval;
        }
        return result;
    }
    
    boolean inBound(int target, int start, int end){
        return target >= start && target <= end;
    }
    boolean overBound(int target, int end){
        return target > end;
    }
}