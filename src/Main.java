public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("book");
        trie.insert("border");
        trie.insert("cat");
        trie.insert("dog");
        trie.insert("doctor");
        trie.insert("fine");
        trie.insert("finest");
        trie.insert("figure");

        int a = trie.getWordCount();
        System.out.println(a);

        trie.printWords();
    }
}