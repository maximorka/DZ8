package DZ8.Stack;

public class MyStack<K> {
    private Noda<K> head;

    public boolean push(K value) {// добавляет элемент в конец
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
        try{
        while (last.getNext() != null) {
            last = last.getNext();
            count++;
        }}
        catch(Exception ex) {
            count =0;
        }
        return count;
    }

    public K peek() { //возвращает первый элемент в очереди (LIFO)
        Noda<K> last = head;
        try {
            while (last.getNext() != null) {
                last = last.getNext();
            }
            return last.getValue();
        }catch (Exception e){
            throw  new IndexOutOfBoundsException(" Size: "+size());
        }
    }

    public K pop() { //возвращает первый элемент в очереди и удаляет его из коллекции
        Noda<K> last = head;
        int count = size();

        for (int i = 0; i <count-2 ; i++) {
            last = last.getNext();
        }
        try{
            Noda<K> res = last.getNext();
            if(res==null) {
                res = head;
                head = null;
            }
            last.setNext(null);
            return res.getValue();
        }catch (Exception exception){
            throw  new IndexOutOfBoundsException(" Size: "+size());
        }

    }

}
