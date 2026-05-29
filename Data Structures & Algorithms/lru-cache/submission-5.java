class LRUCache {

    int cap=0;
    LinkedHashMap<Integer,Integer>lhm=new LinkedHashMap<>();
    public LRUCache(int capacity) {
        cap=capacity;
    }
    
    public int get(int key) {
        if(!lhm.containsKey(key)) return  -1;
        int val=lhm.remove(key);
        lhm.put(key,val);
        return val;
    }
    
    public void put(int key, int value) {
        if(lhm.containsKey(key)) lhm.remove(key);
        else if(lhm.size()==cap){
            int firstKey=lhm.keySet().iterator().next();
            lhm.remove(firstKey);
        }
        lhm.put(key,value);
    }
}
