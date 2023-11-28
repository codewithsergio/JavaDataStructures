import org.w3c.dom.traversal.NodeIterator;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Node root;
    private int wordCount;
    private class Node{
        char value;
        Map<Character, Node> children;
        boolean isEndOfWord;
        Node(char value) {
            this.value = value;
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        private boolean hasCharacter(char letter){
            return children.containsKey(letter);
        }

        private void addCharacter(char letter){
            Node newNode = new Node(letter);
            children.put(letter, newNode);
        }

        private Node getCharacterNode(char letter){
            return children.get(letter);
        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]); // new Node[0] so we get Nodes instead of Objects
        }
    }
    Trie(){
        this.root = new Node('\n');
        this.wordCount = 0;
    }
    public void insert(String word){
        Node nodeIterator = root;
        for(char letter: word.toCharArray()){
            if(!nodeIterator.hasCharacter(letter))
                nodeIterator.addCharacter(letter);
            nodeIterator = nodeIterator.getCharacterNode(letter);
        }
        nodeIterator.isEndOfWord = true;
        wordCount++;
    }

    public boolean hasWord(String word){
        // returns if word is defined as a word //
        if(word == null)
            return false;
        Node nodeIterator = root;
        for(char letter: word.toCharArray()){
            if(!nodeIterator.hasCharacter(letter))
                return false;
            nodeIterator = nodeIterator.getCharacterNode(letter);
        }
        return nodeIterator.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node root){
        System.out.println(root.value);
        for(Node child: root.getChildren())
            traverse(child);
    }

    public int getWordCount(){
        return wordCount;
    }

    public void printWords() {
        printWords(root, "");
    }

    private void printWords(Node node, String currentWord) {
        if (node.isEndOfWord) {
            System.out.println(currentWord);
        }

        for (Node child : node.getChildren()) {
            printWords(child, currentWord + child.value);
        }
    }
}
