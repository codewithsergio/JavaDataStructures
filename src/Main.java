public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        
=======
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
>>>>>>> 98140578ce5bbef1008b69f55fb3eb88758ebee7
    }
}