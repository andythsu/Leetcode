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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return useMoreTime(root);
    }
    public List<List<Integer>> useMoreTime(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(0, tempList);
        }
        return list;
    }
    public List<List<Integer>> useMoreSpace(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List> stack = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            stack.push(tempList);
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
