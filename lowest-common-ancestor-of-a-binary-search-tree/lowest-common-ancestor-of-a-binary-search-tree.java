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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            TreeNode temp = q;
            q = p;
            p = temp;
        }
        while(true){
            if(root.val >= p.val && root.val <= q.val){
                return root;
            }else{
                if(root.val > q.val){
                    root = root.left;
                }else{
                    root = root.right;
                }
            }
        }
    }
}