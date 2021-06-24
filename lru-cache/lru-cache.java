class LRUCache {
    
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node n = map.get(key);
            removeNode(n);
            insertFront(n);
            return n.val;
        }
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n != null){
            removeNode(n);
            n.val = value;
            insertFront(n);
        }else{
            if(map.size() == capacity){
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            map.put(key, newNode);
            insertFront(newNode);
        }
    }
    
    public void removeNode(Node n){
        Node nextNode = n.next;
        Node prevNode = n.prev;
        
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    
    public void insertFront(Node n){
        Node headNext = head.next;
        n.next = headNext;
        headNext.prev = n;
        head.next = n;
        n.prev = head;
    }
    
    
    class Node{
        Node prev;
        Node next;
        int val;
        int key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */