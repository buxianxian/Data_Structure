public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void Set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
