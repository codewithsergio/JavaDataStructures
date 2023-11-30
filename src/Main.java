import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        int[] array = {10, 5, 15, 2, 7, 12, 20};
        for(int number: array){
            tree.insert(number);
        }
        //tree.displayTree();
        System.out.println();
        System.out.println("--------------");

        BinarySearchTree tree2 = new BinarySearchTree();
        int[] array2 = {100, 30, 150, 20, 50, 120, 160, 10, 25, 45, 70, 110, 125, 155, 180, 5, 15, 23, 28, 36, 48, 60, 78, 105, 115, 123, 128, 154, 158, 165, 200};
        for(int number: array2){
            tree2.insert(number);
        }
        //tree2.displayTree();

        BinarySearchTree tree3 = new BinarySearchTree();
        int[] array3 = {100, 130, 150};
        for(int number: array3){
            tree3.insert(number);
        }
        tree3.displayTree();
    }
}
// functions to add
// isComplete() BST