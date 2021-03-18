class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> all = new ArrayList<>();
        backtracking(all, new ArrayList<>(), k, n, 0, 1);
        return all;
    }
    public void backtracking(List<List<Integer>> all, List<Integer> tempList, int sizeLimit, int target, int currentSum, int start){
        if(sizeLimit < tempList.size() || currentSum > target) return;
        if(currentSum == target){
            if(sizeLimit != tempList.size()) return;
            all.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start; i<=9; i++){
            tempList.add(i);
            backtracking(all, tempList, sizeLimit, target, currentSum+i, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}