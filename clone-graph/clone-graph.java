/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> map = new HashMap();
        queue.add(node);
        
        Set<Integer> visited = new HashSet();
        visited.add(node.val);
        
        map.put(node.val, new Node(node.val));
        
        while(!queue.isEmpty()){
            Node oldNode = queue.poll();
            Node newNode = map.get(oldNode.val);
            
            List<Node> neighbors = oldNode.neighbors;
            List<Node> newNeighbors = new ArrayList();
            
            for(Node n : neighbors){                
                Node newNeighborNode = map.getOrDefault(n.val, new Node(n.val));
                map.put(n.val, newNeighborNode);

                newNeighbors.add(newNeighborNode);  
                
                if(!visited.contains(n.val)){
                    queue.add(n);
                }
                visited.add(n.val);
            }
            newNode.neighbors = newNeighbors;
        }
        return map.get(node.val);
    }
}