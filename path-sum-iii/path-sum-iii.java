/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> sumCount = new HashMap();
        sumCount.put(0, 1);
        return traverse(root, sumCount, 0, targetSum);
    }
    
    public int traverse(TreeNode root, Map<Integer, Integer> sumCount, int sum, int targetSum){
        if(root == null) return 0;
        
        sum += root.val;
        
        int count = sumCount.getOrDefault(sum - targetSum, 0);
        
        sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        
        count += traverse(root.left, sumCount, sum, targetSum) + traverse(root.right, sumCount, sum, targetSum);
        
        sumCount.put(sum, sumCount.get(sum) - 1);
        
        return count;
    }
}