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
    public boolean findTarget(TreeNode root, int k) {
        return solution2(root, k);
    }
    
    // time: O(log n); space: O(n)
    public boolean solution2(TreeNode root, int target){
        List<Integer> list = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack();
        
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            if(root.right != null) root = root.right;
            else root = null;
        }      
        
        
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int sum = list.get(left) + list.get(right);
            if(target > sum){
                left++;
            }else if (target < sum){
                right--;
            }else{
                return true;
            }
        }
        return false;
    }
    
    // time: O(nLogn), space: O(1)
    public boolean solution1(TreeNode root, int target, TreeNode treeRoot){
        if(root == null) return false;
        int complement = target - root.val;
        
        if(find(treeRoot, complement, root)) return true;
        
        if(find(treeRoot, complement, root)) return true;

        return solution1(root.left, target, treeRoot) || solution1(root.right, target, treeRoot);
    }
    
    public boolean find(TreeNode treeRoot, int target, TreeNode curRoot){
        if(treeRoot == null) return false;
        if(treeRoot.val == target && treeRoot != curRoot) return true;
        
        if(treeRoot.val < target){
            return find(treeRoot.right, target, curRoot);
        }else{
            return find(treeRoot.left, target, curRoot);
        }
    }
}