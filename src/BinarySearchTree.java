import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    public Node root;
    public int height;
    private class Node{
        int number;
        Node leftChild;
        Node rightChild;
        Node(int number){
            this.number = number;
            leftChild = null;
            rightChild = null;
            height = 0;
        }

        private boolean hasRightChild(){
            return rightChild != null;
        }

        private boolean hasLeftChild(){
            return leftChild != null;
        }
    }

    public void insert(int valueToAdd){
        Node newNode = new Node(valueToAdd);
        int currentHeight = 0;
        if(root == null){
            // Initialize root
            root = newNode;
            height = 1;
            return;
        }
        Node nodeIterator = root;
        while(true){
            currentHeight++;
            if(nodeIterator.number > valueToAdd){ // go left
                if(nodeIterator.hasLeftChild()){
                    nodeIterator = nodeIterator.leftChild;
                } else {
                    nodeIterator.leftChild = newNode;
                    break;
                }
            } else {
                if(nodeIterator.hasRightChild()){ // go right
                    nodeIterator = nodeIterator.rightChild;
                } else {
                    nodeIterator.rightChild = newNode;
                    break;
                }
            }
        }
        if(currentHeight > height) height = currentHeight;
    }

    public boolean hasValue(int valueToFind){
        Node nodeIterator = root;
        while(true){
            if(nodeIterator.number > valueToFind){ // search left
                if(nodeIterator.hasLeftChild()){
                    nodeIterator = nodeIterator.leftChild;
                } else
                    return false;
            } else if(nodeIterator.number < valueToFind) { // search right
                if(nodeIterator.hasRightChild()){
                    nodeIterator = nodeIterator.rightChild;
                } else
                    return false;
            } else
                return true;
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

    public void levelOrderTraversal(){
        if(root == null) return;
        // Level Order Traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueLength = queue.size(); // current level length
            while(queueLength > 0){
                Node node = queue.remove();
                queueLength--;
                if(node == null) {
                    continue;
                }
                System.out.println(node.number);
                if(node.hasLeftChild()){
                    queue.add(node.leftChild);
                } else {
                    queue.add(null);
                }
                if(node.hasRightChild()) {
                    queue.add(node.rightChild);
                } else{
                    queue.add(null);
                }
            }
        }
    }

    public int kthSmallest(int k){
        return kthSmallest(root, k);
    }

    private int kthSmallest(Node root, int k) {
        if (root == null) {
            return -1; // or any value that represents not found
        }

        int leftCount = countNodes(root.leftChild);
        if (k <= leftCount) {
            return kthSmallest(root.leftChild, k);
        } else if (k == leftCount + 1) {
            return root.number;
        } else {
            return kthSmallest(root.rightChild, k - leftCount - 1);
        }
    }

    private int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.leftChild) + countNodes(root.rightChild);
    }

// left/right spaces variable: (2 ^ (height - 1) - 1) / (2 * [currentLevel [0 index based]])
// *height: how many levels are there

// each level after will just divide that value by 2
// middle spaces == previous level's left/right spaces
//


    public void displayTree(){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nodesInCurrentLevel = 1;
        int spaces = (int)Math.pow(2, (height)) - 1;
        int middleSpaces = 0;

        while(!queue.isEmpty()){
            printNSpaces(spaces); // left spaces
            int queueLength = queue.size(); // current level length
            int currentLevel = log2(nodesInCurrentLevel) + 1;
            while(queueLength > 0){
                Node node = queue.remove();
                queueLength--;

                if(node == null) {
                    System.out.print("(---)");
                } else {
                    System.out.printf("(%3d)", node.number);
                }
                if(middleSpaces < 0) return;
                printNSpaces(middleSpaces); // middle space for each value

                if(node != null) {
                    queue.add(node.leftChild);
                    queue.add(node.rightChild);
                } else {
                    queue.add(null);
                    queue.add(null);
                }
            }

            nodesInCurrentLevel *= 2;
            middleSpaces = spaces;
            if(middleSpaces == 0) return;
            spaces = (int)Math.pow(2, (height - currentLevel)) - 1;

            System.out.println();
        }
    }

    public void printNSpaces(int n){
        if(n < 0) return;
        System.out.print("     ".repeat(n));
    }

    public int log2(int N) {
        return (int) (Math.log(N) / Math.log(2));
    }

    public boolean isComplete(){
        if(root == null) return false;
        // Level Order Traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean hasHole = false;
        while(!queue.isEmpty()){
            Node node = queue.remove();
            while(node != null){
                if((node.hasLeftChild() || node.hasRightChild()) && hasHole) return false;
                if(!node.hasLeftChild() && node.hasRightChild()) return false;
                if(node.hasLeftChild() && node.hasRightChild()){
                    queue.add(node.leftChild);
                    queue.add(node.rightChild);
                } else {
                    if(node.hasLeftChild())
                        queue.add(node.leftChild);
                    hasHole = true;
                }
                try{
                    node = queue.remove();
                }catch(Exception e){
                    break;
                }
            }
        }
        return true;
    }
}
