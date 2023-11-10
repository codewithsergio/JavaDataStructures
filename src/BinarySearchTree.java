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
    }
    // Functions: addValue, hasValue, traverseInOrder, traverseLevelOrder

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
                if(nodeIterator.leftChild != null){
                    nodeIterator = nodeIterator.leftChild;
                } else {
                    nodeIterator.leftChild = newNode;
                    return;
                }
            } else {
                if(nodeIterator.rightChild != null){ // go right
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
            if(nodeIterator.number > valueToFind){ // go left
                if(nodeIterator.leftChild != null){
                    nodeIterator = nodeIterator.leftChild;
                } else {
                    return false;
                }
            } else if(nodeIterator.number < valueToFind) { // go right
                if(nodeIterator.rightChild != null){
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

    }
}
