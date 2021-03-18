class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<>();
        backtracking(all, new ArrayList<>(), candidates, target, 0, 0);
        return all;
    }
    public void backtracking(List<List<Integer>> all, List<Integer> currentList, int[] candidates, int target, int currentSum, int startIndex){
        if(currentSum > target) return;
        if(currentSum == target){
            all.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=startIndex; i<candidates.length; i++){
            currentList.add(candidates[i]);
            backtracking(all, currentList, candidates, target, currentSum+candidates[i], i);
            currentList.remove(currentList.size() - 1);
        }
    }
}