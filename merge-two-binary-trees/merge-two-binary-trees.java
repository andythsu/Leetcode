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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 != null && root2 == null) return root1;
        if(root1 == null && root2 != null) return root2;
        return helper(root1, root2);
    }
    public TreeNode helper(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return null;
        TreeNode node = new TreeNode();
        
        int root1Val = root1 != null ? root1.val : 0;
        int root2Val = root2 != null ? root2.val : 0;
        
        node.val = root1Val + root2Val;
        
        node.left = helper(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        node.right = helper(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        
        return node;
    }
}