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
    int max = Integer.MIN_VALUE;
    
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int leftMax = 0;
        int rightMax = 0;
        if(root.left != null && root.left.val == root.val){
            leftMax = leftMax + left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rightMax = rightMax + right + 1;
        }
        
        max = Math.max(max, leftMax + rightMax);
        
        return Math.max(leftMax, rightMax);
        
    }
    
}