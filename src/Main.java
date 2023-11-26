public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(7);
        tree.insert(10);
        tree.insert(4);
        int r = tree.kthSmallest(4);
        System.out.println(r);
    }
}