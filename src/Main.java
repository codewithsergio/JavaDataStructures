public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(4);
        cache.add(5);
        cache.add(6);
        cache.add(7);
        cache.get(4);
        cache.add(6);
        cache.add(2);
        cache.get(1);
        cache.add(2);
    }
}