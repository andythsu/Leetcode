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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                TreeNode n = queue.poll();
                if(i == length - 1){
                    list.add(n.val);
                }
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }
        }
        
        return list;
        
    }
}