import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Node root;
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
    }
    Trie(){
        this.root = new Node('\n');
    }
    public void insert(String word){
        Node nodeIterator = root;
        for(char letter: word.toCharArray()){
            if(!nodeIterator.hasCharacter(letter)){
                nodeIterator.addCharacter(letter);
            }
            nodeIterator = nodeIterator.getCharacterNode(letter);
        }
        nodeIterator.isEndOfWord = true;
    }
}
