import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;
    private class Node{
        int number;
        Node leftChild;
        Node rightChild;
        Node(int number){
            this.number = number;
            this.leftChild = null;
            this.rightChild = null;
        }

        private boolean hasRightChild(){
            return rightChild != null;
        }

        private boolean hasLeftChild(){
            return leftChild != null;
        }
    }
    // Functions: addValue, hasValue, traverseInOrder, traverseLevelOrder
    // think about adding: delete node

    public void addValue(int valueToAdd){
        Node newNode = new Node(valueToAdd);
        if(root == null){
            // Initialize root
            root = newNode;
            return;
        }
        Node nodeIterator = root;
        while(true){
            if(nodeIterator.number > valueToAdd){ // go left
                if(nodeIterator.hasLeftChild()){
                    nodeIterator = nodeIterator.leftChild;
                } else {
                    nodeIterator.leftChild = newNode;
                    return;
                }
            } else {
                if(nodeIterator.hasRightChild()){ // go right
                    nodeIterator = nodeIterator.rightChild;
                } else {
                    nodeIterator.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public boolean hasValue(int valueToFind){
        Node nodeIterator = root;
        while(true){
            if(nodeIterator.number > valueToFind){ // search left
                if(nodeIterator.hasLeftChild()){
                    nodeIterator = nodeIterator.leftChild;
                } else {
                    return false;
                }
            } else if(nodeIterator.number < valueToFind) { // search right
                if(nodeIterator.hasRightChild()){
                    nodeIterator = nodeIterator.rightChild;
                } else {
                    return false;
                }
            } else { // found value
                return true;
            }
        }
    }

    public void traverseInOrder(){
        if(root == null){
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.number);
        traverseInOrder(root.rightChild);
    }

    private void traverseInOrder(Node root){
        if(root == null){
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.number);
        traverseInOrder(root.rightChild);
    }

    public void traverseLevelOrder(){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node thisNode = queue.element();
            // Print current node
            System.out.println(thisNode.number);
            // Add left if exists
            if(thisNode.hasLeftChild()){
                queue.add(thisNode.leftChild);
            }
            // Add right if exists
            if(thisNode.hasRightChild()){
                queue.add(thisNode.rightChild);
            }
            queue.remove();
        }
    }
}
