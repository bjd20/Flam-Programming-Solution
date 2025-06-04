import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> cacheMap;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        // dummy head and tail nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }

        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node != null) { // Already exist : Just update value
            node.value = value;
            moveToFront(node);
        } else {
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addToFront(newNode);

            // Check capacity
            if (cacheMap.size() > capacity) {
                Node evict = tail.prev;
                removeNode(evict);
                cacheMap.remove(evict.key);
            }
        }
    }
    
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    public void displayAll(){

        System.out.printf("All the contents of cache: \n");

        for(int k : cacheMap.keySet()){
            System.out.println(k + " : " + cacheMap.get(k).value);
        }
    }
}