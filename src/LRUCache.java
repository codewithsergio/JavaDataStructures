import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public static class Node {
        int number;
        Node next;
        Node prev;
        Node(int number){
            this.number = number;
            next = null;
            prev = null;
        }
    }
    LRUCache(int capacity){
        this.capacity = capacity;
        this.head = this.tail = null;
        this.map = new HashMap<>();
    }

    public void add(int value){ // add to hashmap / DL list
        Node newNode = new Node(value);
        if(!map.containsKey(value)){ // Add node to end of DL list
            if(head == null){
                head = newNode;
            } else {
                tail.next = newNode;
                tail.next.prev = tail;
            }
            tail = newNode;

            // Add node to map
            map.put(value, newNode);
        } else { // Remove existing node from DL list and put at end
            remove(map.get(value));
            map.remove(value);
            add(value);
        }
        if(map.size() > capacity){
            // remove least used node from DL list and map
            System.out.println("Removing " + head.number);
            map.remove(head.number);
            remove(head);
        }
    }

    private void remove(Node nodeToRemove){ // Remove from DL list
        System.out.println(head + " " + nodeToRemove + " " + nodeToRemove.number);
        if(nodeToRemove == head){ // Remove if head
            if(nodeToRemove.next == null){
                nodeToRemove = null;
                return;
            }
            head = nodeToRemove.next;
            head.prev = null;
        } else if(nodeToRemove == tail) { // Remove if tail
            tail = nodeToRemove.prev;
            tail.next = null;
        } else { // Remove if middle node
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        nodeToRemove = null;
    }

    public void get(int value){ // get from hashmap and DL list
        if(map.containsKey(value)){
            remove(map.get(value));
            map.remove(value);
            add(value);
        }
    }
}
