package DZ8.HashMap;

public class Noda<K,V> {
    private int hash;
    private K key;
    private V value;
    private Noda<K,V> next;


    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Noda<K,V> getNext() {
        return next;
    }

    public void setNext(Noda<K,V> next) {
        this.next = next;
    }
}
