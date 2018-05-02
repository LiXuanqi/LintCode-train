public class LRUCache {
    /*
    * @param capacity: An integer
    */
    private class Node {
        private int key;
        private int value;
        public Node prevNode;
        public Node nextNode;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prevNode = null;
            this.nextNode = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> map;
    Node tail;
    Node head;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        tail = new Node(-1, -1);
        head = new Node(-1, -1);
        head.nextNode = tail;
        tail.prevNode = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node currentNode = map.get(key);
            currentNode.prevNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.prevNode = currentNode.prevNode;
            
            moveToTail(currentNode);
            
            return currentNode.value;
            
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // if the key is already present, replace the key-value and move the node to the tail.
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            Node removeNode = map.get(key);
            removeNode.prevNode.nextNode = removeNode.nextNode;
            removeNode.nextNode.prevNode = removeNode.prevNode;
            moveToTail(newNode);
            map.put(key, newNode);
            return;
        }
 
        if (map.size() == capacity) {
            // should delete the first node.
            Node firstNode = head.nextNode;
            head.nextNode = firstNode.nextNode;
            firstNode.nextNode.prevNode = head;
            map.remove(firstNode.key);
        }
        moveToTail(newNode);
        map.put(key, newNode);
    }
    
    private void moveToTail(Node node) {
        Node prevNode = tail.prevNode;
        prevNode.nextNode = node;
        node.prevNode = prevNode;
        tail.prevNode = node;
        node.nextNode = tail;
    }
    
}