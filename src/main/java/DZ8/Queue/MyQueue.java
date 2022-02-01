package DZ8.Queue;

public class MyQueue<K> {
    private Noda<K> head;

    public boolean add(K value) {// добавляет элемент в конец
        Noda<K> noda = new Noda<>();
        noda.setValue(value);

        if (head == null) {
            head = noda;
        } else {
            Noda<K> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(noda);
        }
        return true;
    }

    public boolean remove(int index) {//удаляет элемент под индексом
        if (index == 0) {
            head = head.getNext();
            return true;
        }

        Noda<K> last = head;
        for (int i = 0; i < index - 1; i++) {
            last = last.getNext();
        }

        Noda<K> next = last.getNext();
        last.setNext(next.getNext());
        return true;
    }

    public boolean clear() { //очищает коллекцию
        head = null;
        return true;
    }

    public int size() {//возвращает размер коллекции
        Noda<K> last = head;
        int count = 1;
        try {
            while (last.getNext() != null) {
                last = last.getNext();
                count++;
            }
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public K peek() { //возвращает первый элемент в очереди (FIFO)
        try {
            return head.getValue();
        } catch (Exception e) {
            throw new IndexOutOfBoundsException(" Size: " + size());
        }
    }

    public K poll() { //возвращает первый элемент в очереди и удаляет его из коллекции
        try {
            Noda<K> res = head;
            head = head.getNext();
            return res.getValue();

        } catch (Exception e) {
            throw new IndexOutOfBoundsException(" Size: " + size());
        }
    }

}
