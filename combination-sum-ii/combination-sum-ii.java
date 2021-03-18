class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> all = new ArrayList<>();
        backtracking(all, new ArrayList<>(), candidates, 0, target, 0);
        return all;
    }
    public void backtracking(List<List<Integer>> all, List<Integer> tempList, int[] candidates, int currentSum, int target, int startIndex){
        if(currentSum > target) return;
        if(currentSum == target){
            all.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=startIndex; i<candidates.length; i++){
            if(i > startIndex && candidates[i] == candidates[i-1]) continue;
            tempList.add(candidates[i]);
            backtracking(all, tempList, candidates, currentSum+candidates[i], target, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}