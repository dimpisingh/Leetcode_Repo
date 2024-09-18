class LRUCache {
    int capacity;
    Map<Integer, Integer> cacheMap;
    LinkedList<Integer> lruList ;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }
    
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        else{
            lruList.remove(Integer.valueOf(key));
            lruList.addFirst(key);
        }
        return cacheMap.get(key);

    }
    
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
        cacheMap.put(key, value);
        lruList.remove(Integer.valueOf(key));
        lruList.addFirst(key);
    }
    else{
         if (cacheMap.size() >= capacity) {
            int leastUsedKey = lruList.removeLast();
                cacheMap.remove(leastUsedKey);
            }
            cacheMap.put(key, value);
            lruList.addFirst(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */