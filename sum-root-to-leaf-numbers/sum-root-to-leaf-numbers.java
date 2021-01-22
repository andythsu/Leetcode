/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return iterative(root);
    }
    public int iterative(TreeNode root){
        if(root == null) return 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, root.val));
        int sum = 0;
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            int val = p.getValue();
            if(node.left == null && node.right == null){
                sum += val;
                continue;
            }
            if(node.left != null) stack.push(new Pair(node.left, val * 10 + node.left.val));
            if(node.right != null) stack.push(new Pair(node.right, val * 10 + node.right.val));
        }
        return sum;
    }
}
