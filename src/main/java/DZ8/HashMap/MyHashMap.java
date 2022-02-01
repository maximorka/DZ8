package DZ8.HashMap;


public class MyHashMap<K, V> {
    private int capacity;
    private final int startCapacity = 16;
    private float loadFactor;
    private Noda[] table;
    private int threshold;
    private int size;

    public MyHashMap() {
        this.capacity = startCapacity;
        this.loadFactor = 0.75F;
        table = new Noda[capacity];
        this.threshold = (int) (capacity * loadFactor);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.loadFactor = 0.75F;
        table = new Noda[capacity];
        this.threshold = (int) (capacity * loadFactor);
    }

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        table = new Noda[capacity];
        this.threshold = (int) (capacity * loadFactor);
    }

    public void put(K key, V value) {//добавляет пару ключ + значение
        if (key != null) {
            int hash = hash(key);
            int index = calcIndex(hash, capacity);
            table[index] = add(key, value, hash, index);
        }else{
            table[0] = add(null, value, 0, 0);
        }
    }

    private Noda add(K key, V value, int hash, int index) {
        if (size > threshold) {
            capacity *= 2;
            resize();
        }

        Noda oldNoda = table[index];

        if (oldNoda != null) {
            if (oldNoda.getHash() == hash && (oldNoda.getKey() == key || oldNoda.getKey().equals(key))) {
                oldNoda.setValue(value);
                return oldNoda;
            }
        }

        Noda<K, V> newNoda = new Noda<>();
        newNoda.setKey(key);
        newNoda.setValue(value);
        newNoda.setHash(hash);
        newNoda.setNext(oldNoda);
        size++;
        return newNoda;
    }


    public void remove(K key) {// удаляет пару по ключу
        int hash = hash(key);
        int index = calcIndex(hash, capacity);
        Noda noda = table[index];
        Noda preNoda = noda;

        try{
            while (noda.getHash() != hash) {
                preNoda = noda;
                noda = noda.getNext();
            }
        }catch (Exception ex){
            //System.out.println(ex);
            return;
        }

        if (preNoda.equals(noda)) {
            table[index] = noda.getNext();
        } else {
            preNoda.setNext(noda.getNext());
            table[index] = preNoda;
        }
        size--;
    }

    public void clear() {// очищает коллекцию
        table = new Noda[startCapacity];
        size=0;
    }

    public int size() {// возвращает размер коллекции
        int count = 0;
        for (Noda noda : table) {
            while (noda != null) {
                count++;
                noda = noda.getNext();
            }
        }
        return count;
    }

    public V get(K key) {// возвращает значение(Object value) по ключу
        int hash = hash(key);
        int index = calcIndex(hash, capacity);
        Noda noda = table[index];
        if (noda != null) {
            while (noda.getHash() != hash) {
                noda = noda.getNext();
                if (noda == null)
                    return null;
            }
            return (V) noda.getValue();
        }
        return null;
    }


    private int hash(K key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int calcIndex(int hash, int lengthTable) { return hash & (lengthTable - 1); }

    private void resize() {
        Noda[] newTable = new Noda[capacity];
        table = new Noda[capacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (capacity * loadFactor);
    }

    private void transfer(Noda[] newTable) {
        for (Noda<K, V> noda : newTable) {
            while (noda != null) {
                if (noda.getKey() != null) {

                    int hash = hash(noda.getKey());
                    int index = calcIndex(hash, capacity);
                    newTable[index] = addTransfer(noda.getKey(), noda.getValue(), hash, index, newTable);
                }else{
                    newTable[0] = addTransfer(noda.getKey(), noda.getValue(), 0, 0, newTable);
                }
                noda = noda.getNext();
            }
        }
    }

    private Noda<K, V> addTransfer(K key, V value, int hash, int index, Noda<K, V>[] t) {

        Noda<K, V> oldNoda = t[index];
        if (oldNoda != null) {
            if (oldNoda.getHash() == hash && (oldNoda.getKey() == key || oldNoda.getKey().equals(key))) {
                oldNoda.setValue(value);
                return oldNoda;
            }
        }

        Noda<K, V> newNoda = new Noda<>();
        newNoda.setKey(key);
        newNoda.setValue(value);
        newNoda.setHash(hash);
        newNoda.setNext(oldNoda);
        return newNoda;
    }

}
