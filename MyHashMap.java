class MyHashMap {
    private final int SIZE = 10000; // Size of the array (number of buckets)
    private Node[] buckets; // Array of linked lists

    // Node class to store key-value pairs
    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node newNode = new Node(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node prev = findElement(key);
            if (prev.next == null) {
                prev.next = newNode;
            } else {
                prev.next.value = value;
            }
        }
    }

    public int get(int key) {
        Node prev = findElement(key);

        if (prev.next == null) {
            return -1; // Key not found
        } else {
            return prev.next.value;
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node prev = findElement(key);

        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private Node findElement(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return buckets[index] = new Node(-1, -1);
        }

        Node prev = buckets[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }

        return prev;
    }
}

class main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1, 1);
        myHashMap.put(2, 2);

        System.out.println(myHashMap.get(1)); // Output: 1

        System.out.println(myHashMap.get(3)); // Output: -1

        myHashMap.put(2, 1);

        System.out.println(myHashMap.get(2)); // Output: 1

        myHashMap.remove(2);

        System.out.println(myHashMap.get(2)); // Output: -1
    }
}
