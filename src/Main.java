public class Main {
    public static void main(String[] args) throws Exception {
        MyHeap heap = new MyHeap(9);
        heap.insert(15);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(12);
        heap.insert(9);
        heap.insert(4);
        heap.insert(1);
        heap.insert(24);
        heap.remove();
        System.out.println(heap);
    }
}
// functions to add
// isComplete() BST