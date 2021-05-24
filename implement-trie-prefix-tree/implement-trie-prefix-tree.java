class Trie {
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(false, '-');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node iterator = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(iterator.map[c - 'a'] != null){
                iterator = iterator.map[c - 'a'] ;
                if(i == word.length() - 1) {
                    iterator.isEnd = true;
                    break;
                }
                continue;
            }
            Node n = null;
            if(i == word.length() - 1){
                // last element
                n = new Node(true, word.charAt(i));
            }else{
                n = new Node(false, word.charAt(i));
            }
            iterator.map[c - 'a'] = n;
            iterator = iterator.map[c - 'a'];
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node iterator = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            iterator = iterator.map[c - 'a'];
            if(iterator == null){
                return false;
            }
        }
        
        if(iterator.isEnd){
            return true;
        }
        
        return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node iterator = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            iterator = iterator.map[c - 'a'];
            if(iterator == null){
                return false;
            }
        }
        return true;
    }
    
    class Node{
        boolean isEnd;
        char val;
        Node[] map;
        public Node(boolean isEnd, char val){
            this.isEnd = isEnd;
            this.val = val;
            map = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
