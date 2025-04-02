class Node {
    Node prev;
    Node next;
    int val;
    int key;

    public Node(Node prev, Node next, int val, int key) {
        this.prev = prev;
        this.next = next;
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new Node(null, null, -1, -1);
        right = null;
    }

    public int get(int key) {
        Node n = map.getOrDefault(key, null);
        boolean exist = n != null;

        if (!exist) {
            return -1;
        }

        put(n.key, n.val);

        return n.val;
    }

    public void put(int key, int value) {
        Node n = map.getOrDefault(key, null);
        boolean exist = n != null;

        if (n == null) {
            n = new Node(null, null, value, key);
        } else {//when exist, we need update the value
            n.val = value;
        }

        //when is the first time
        if (right == null) {
            n.next = null;
            n.prev = left;

            left.next = n;
            right = n;
            map.put(key, n);
        } else if (!exist) {// when is a new node
            right.next = n;
            n.prev = right;
            n.next = null;
            right = right.next;
            map.put(key, n);
        } else if (!right.equals(n)) { //when is a node that exist but isnt the Last Recently use
            updateFront(n);
        }

         if (map.size() > capacity) {
            Node leftNext = left.next;
            map.remove(leftNext.key);
            left.next = leftNext.next; 
            if (leftNext.next != null) {
                leftNext.next.prev = left;
            }
            if (right == leftNext) {
                right = null;
            }
        }
    }

    private void updateFront(Node node) {
        //1 <-> 2 <-> 3
        //node = 2
        //rigth = 3
        Node prev = node.prev;//1
        Node next = node.next;//3
        prev.next = next;//1 -> 3
        next.prev = prev;//1<-3 
        node.next = null;//2 -> null
        node.prev = right;//3<-2
        right.next = node;//3->2
        right = right.next;//(3) -> 2

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */