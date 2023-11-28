import java.util.Stack;

public class MyLinkedList {
    private Node head;
    private Node tail;

    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            next = null;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Node i = head; i != null; i = i.next){
            result.append(i.value).append(" ");
        }
        return result.toString();
    }

    public void insertAtEnd(int valueToAdd){
        Node node = new Node(valueToAdd);
        if(head == null){
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void deleteAt(int index){
        Node curNode = head;
        Node prevNode = new Node(-1);
        int i = 0;
        while(curNode != null){
            if(i == index) break;
            i++;
            prevNode = curNode;
            curNode = curNode.next;
        }
        if(curNode == null) return;
        if(curNode.next != null){
            prevNode.next = curNode.next;
            curNode.next = null;
        } else {
            prevNode.next = null;
        }
    }

    public void reverse(){
        Stack<Integer> stack = new Stack<>();
        for(Node i = head; i != null; i = i.next)
            stack.add(i.value);
        head = null;
        tail = null;
        while(!stack.empty()){
            insertAtEnd(stack.pop());
        }
    }
}
