/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        int left = helper(root.left, p, q) ? 1 : 0 ;
        int right = helper(root.right, p, q) ? 1 : 0;
        int isRootLCA = (root.val == p.val || root.val == q.val) ? 1 : 0 ;
        if(left + right + isRootLCA >= 2) ans = root; 
        return left + right + isRootLCA > 0;
    }
}