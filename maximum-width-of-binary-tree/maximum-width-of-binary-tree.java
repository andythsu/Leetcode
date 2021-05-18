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
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();    
    public int widthOfBinaryTree(TreeNode root) {
        getWidth(root, 0, 0);
        return max;
    }
    
    public void getWidth(TreeNode root, int position, int depth){
        if(root == null) return;
        map.computeIfAbsent(depth, x -> position);
        max = Math.max(max, position - map.get(depth) + 1);
        getWidth(root.left, position * 2, depth+1);
        getWidth(root.right, position * 2+1, depth+1);
    }
}