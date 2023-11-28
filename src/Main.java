public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(1);
        tree.insert(8);
        tree.insert(6);
        tree.insert(12);
        tree.insert(10);
        tree.insert(16);
        int r = tree.kthSmallest(5);
        System.out.println(r);
    }
}