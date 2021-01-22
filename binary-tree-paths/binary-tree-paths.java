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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        recursive(root, "", ret);
        return ret;
    }
    public void recursive(TreeNode root, String str, List<String> ret){
        if(root == null) return;      
        if(root.left == null && root.right == null){
            ret.add(str+root.val);
        }else{
            if(root.left != null) recursive(root.left, str+root.val+"->", ret);
            if(root.right != null) recursive(root.right, str+root.val+"->", ret);
        }
    }
    public List<String> iterative(TreeNode root){
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair(root, ""));
        while(!stack.isEmpty()){
            Pair<TreeNode, String> p = stack.pop();
            TreeNode node = p.getKey();
            String str = p.getValue();
            // leaf
            if(node.left == null && node.right == null){
                str+=node.val;
                result.add(str);
                continue;
            }
            
            // push right
            if(node.right != null){
                stack.push(new Pair(node.right, str+node.val+"->"));
            }
            
            // push left
            if(node.left != null){
                stack.push(new Pair(node.left, str+node.val+"->"));
            }
        }
        return result;
    }
}
