public class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}

class LRUCache {

    private int cap;
    private HashMap<Integer,Node>cache;
    private Node left; // extreme left
    private Node right; // extreme right

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.cache=new HashMap<>();
        this.left=new Node(0,0);
        this.right=new Node(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;
    }

    // Remove the LRU node which will be in the left
    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    // Insert it in last as it has become MRU node now
    private void insert(Node node){
        right.prev.next=node;
        node.next=right;
        node.prev=right.prev;
        right.prev=node;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        // otherwise make it MRU
        Node node=cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // if key is already present, remove from current place
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        
        // new key-value node will be MRU
        Node newNode=new Node(key,value);
        cache.put(key, newNode);
        insert(newNode);

        // if size is more then remove LRU
        if(cache.size()>cap){
            Node lru=left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
