/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
​
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
​
class Solution {
    public Node copyRandomList(Node head) {
        return usingOneVar(head);
    }
    public Node usingOneVar(Node head){
        if(head == null) return null;
        // make a copy of each node in the list next to its original node
        Node node = head;
        while(node != null){
            Node next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
            node = next;
        }
        
        // make a copy of their random pointer
        node = head;
        while(node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
        // extract the copy
        node = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while(copy.next != null){
            node.next = node.next.next;
            node = node.next;
            
            copy.next = copy.next.next;
            copy = copy.next;
        }
        
        node.next = node.next.next;
        
        return copyHead;
    }
    
    public Node usingMap(Node head){
        if(head == null) return null;
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        map.put(head, new Node(head.val));
        while(node != null){
            if(!map.containsKey(node.random)){
                map.put(node.random, new Node(node.random.val));
            }
            map.get(node).random = map.get(node.random);
            if(!map.containsKey(node.next)){
                map.put(node.next, new Node(node.next.val));
            }
            map.get(node).next = map.get(node.next);
            node = node.next;
        }
        return map.get(head);
    }
}
