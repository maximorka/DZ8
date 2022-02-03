package DZ8.ArrayList;

public class MyArrayList<K> {
    private int size;
    private K[] array;
    private int capacity;
    private final int defCapacity = 10;

    public MyArrayList() {
        size = 0;
        capacity = defCapacity;
        array =  (K[])(new Object[capacity]);
    }

    public boolean add(K value) {
        if (capacity - 1 > size + 1) {
            array[size++] =  value;
        } else {
            capacity = (int) (capacity * 1.5d);
            K[] tmp = (K[]) new Object[size + 1];

            System.arraycopy(array, 0, tmp, 0, tmp.length);
            array = (K[]) new Object[capacity];
            System.arraycopy(tmp, 0, array, 0, tmp.length);
            array[size++] =  value;
        }
        return true;
    }

    public boolean remove(int index) {
        if(index>size)
            throw  new IndexOutOfBoundsException("Index: "+index+", Size: "+size);

        array[index] = null;
        size--;
        for (int i = index; i <size; i++) {
            array[i] = array[i+1];
        }

        return true;
    }

    public void clear() {
        size = 0;
        capacity = defCapacity;
        array = (K[]) new Object[defCapacity];
    }

    public int size() {
        return size;
    }

    public K get(int index) {
        if(index>size)
            throw  new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        return array[index];
    }


}
