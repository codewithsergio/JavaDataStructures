public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.addValue(8);
        tree.addValue(3);
        tree.addValue(4);
        tree.addValue(1);
        tree.addValue(10);
        tree.addValue(9);
        tree.addValue(11);
        tree.traverseLevelOrder();
    }
}