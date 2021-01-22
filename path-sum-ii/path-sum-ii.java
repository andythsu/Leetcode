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
    class Node {
        TreeNode node;
        int sum;
        List<Integer> path;
        public Node(TreeNode node, int sum, List<Integer> path){
            this.node = node;
            this.sum = sum;
            this.path = path;
        }
        public boolean isLeaf(){
            return node.left == null && node.right == null;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, targetSum, Arrays.asList(root.val)));
        while(!stack.isEmpty()){
            Node n = stack.pop();
            if(n.sum == n.node.val && n.isLeaf()){
                result.add(new ArrayList<>(n.path));
                continue;
            }
            
            // push left
            if(n.node.left != null){
                List<Integer> lList = new ArrayList<>(n.path);
                lList.add(n.node.left.val);
                stack.push(new Node(n.node.left, n.sum - n.node.val, lList));
            }
            
            // push right
            if(n.node.right != null){
                List<Integer> rList = new ArrayList<>(n.path);
                rList.add(n.node.right.val);
                stack.push(new Node(n.node.right, n.sum - n.node.val, rList));
            }
        }
        return result;
    }
}
