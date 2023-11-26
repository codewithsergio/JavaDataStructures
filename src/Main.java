public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insertAtEnd(6);
        list.insertAtEnd(3);
        list.insertAtEnd(10);
        list.insertAtEnd(23);
        list.insertAtEnd(9);
        list.insertAtEnd(16);
        list.insertAtEnd(89);
        list.reverse();
        System.out.println(list);
    }
}