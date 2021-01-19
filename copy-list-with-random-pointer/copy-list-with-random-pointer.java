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
        return usingMap(head);
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
