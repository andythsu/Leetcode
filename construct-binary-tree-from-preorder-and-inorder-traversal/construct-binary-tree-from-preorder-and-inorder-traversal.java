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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // use a hashmap to store value->index
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(0, preorder, map, 0, inorder.length-1);
    }
    TreeNode helper(int preIndex, int[] preorder, Map<Integer, Integer> map, int inStart, int inEnd){
        if(inStart > inEnd || preIndex > preorder.length - 1) return null;
        int val = preorder[preIndex];
        TreeNode node = new TreeNode(val);
        int inIndex = map.get(val);
        node.left = helper(preIndex+1, preorder, map, inStart, inIndex - 1);
        node.right = helper(preIndex + inIndex - inStart + 1, preorder, map, inIndex+1, inEnd);
        return node;
    }
}