/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(size == 1){
                Node cur = queue.poll();
                cur.next = null;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right); 
            }else{
                Node prev = queue.poll();
                if(prev.left != null) queue.add(prev.left);
                if(prev.right != null) queue.add(prev.right); 
                Node cur = null;
                for(int i=0; i<size - 1; i++){
                    cur = queue.poll();
                    prev.next = cur;
                    prev = cur;
                    if(cur.left != null) queue.add(cur.left); 
                    if(cur.right != null) queue.add(cur.right); 
                }
                cur.next = null;
            }
        }
        return root;
    }
}