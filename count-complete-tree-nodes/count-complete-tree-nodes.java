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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if(left == right){
            return (1 << left) + countNodes(root.right);
        }else{
            return (1 << right) + countNodes(root.left);
        }
        
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + getHeight(root.left);
    }
}