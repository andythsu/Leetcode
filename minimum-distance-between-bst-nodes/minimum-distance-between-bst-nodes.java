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
    public int minDiffInBST(TreeNode root) {
        // use in-order traversal because it will ensure the minimum distance between 2 adjacent nodes
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        int prev = -1;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            
            if(prev > -1) min = Math.min(min, Math.abs(root.val - prev));
            
            prev = root.val;
            root = root.right;            
        }
        return min;
    }
}