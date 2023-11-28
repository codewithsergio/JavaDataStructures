import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println(tree.isComplete());
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.insert(10);
        tree2.insert(3);
        tree2.insert(12);
        tree2.insert(2);
        System.out.println(tree2.isComplete());
        BinarySearchTree tree3 = new BinarySearchTree();
        tree3.insert(23);
        tree3.insert(12);
        tree3.insert(30);
        tree3.insert(11);
        tree3.insert(15);
        tree3.insert(26);
        tree3.insert(34);
        System.out.println(tree3.isComplete());
        BinarySearchTree tree4 = new BinarySearchTree();
        tree4.insert(23);
        tree4.insert(12);
        tree4.insert(30);
        tree4.insert(11);
        tree4.insert(15);
        tree4.insert(34);
        System.out.println(tree4.isComplete());
    }
}
// functions to add
// isComplete() BST