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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        int level = 0;
        stack.push(root);
        while(!stack.isEmpty()){
            Stack<TreeNode> tempStack = new Stack<>();
            List<Integer> tempList = new ArrayList<>();
            int stackSize = stack.size();
            for(int i=0; i<stackSize; i++){
                TreeNode node = stack.pop();
                tempList.add(node.val);
                if(level % 2 == 0){
                    if(node.left != null) tempStack.push(node.left);
                    if(node.right != null) tempStack.push(node.right);
                }else{
                    if(node.right != null) tempStack.push(node.right);
                    if(node.left != null) tempStack.push(node.left);
                }
            }
            level++;
            result.add(tempList);
            stack = tempStack;
        }
        return result;
    }
}
