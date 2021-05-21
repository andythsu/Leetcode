class RandomizedSet {
    
    Map<Integer, Integer> map;
    List<Integer> list;
    int lastIndex;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
        lastIndex = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, lastIndex);
        lastIndex++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int indexToBeRemoved = map.get(val);
        if(indexToBeRemoved != lastIndex - 1){
            int lastVal = list.get(lastIndex - 1);
            list.set(indexToBeRemoved, lastVal);
            map.put(lastVal, indexToBeRemoved);
        }
        
        list.remove(lastIndex - 1);
        
        map.remove(val);
        
        lastIndex--;
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int randomIndex = r.nextInt(lastIndex - 0) + 0;
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */