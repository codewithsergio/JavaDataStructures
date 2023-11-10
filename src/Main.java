public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.addValue(10);
        tree.addValue(5);
        tree.addValue(7);
        tree.addValue(17);
        tree.addValue(1);
        tree.addValue(13);
        tree.traverseInOrder();
    }
}