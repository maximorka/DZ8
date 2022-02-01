package DZ8.LinkedList;

public class MyLinkedList<T> {
    private Noda<T> first;

    public boolean add(T value) {// добавляет элемент в конец

        if (first == null) {
            first = new Noda<>();
            first.setValue(value);
            Noda<T> tmp = new Noda<T>();
            tmp.setBefore(first);
            first.setNext(tmp);
        } else {
            Noda n = first.getNext();
            n.setNext(new Noda());
            n.setBefore(first);
            n.setValue(value);
            first = n;
        }
        return true;
    }

    public boolean remove(int index) {//удаляет элемент под индексом
        Noda<T> geting = first;
        while (geting.getBefore() != null) {
            geting = geting.getBefore();
        }

        try {
            for (int i = 0; i < index; i++) {
                geting = geting.getNext();
            }
            geting.getBefore().setNext(geting.getNext());
            geting.getNext().setBefore(geting.getBefore());
        } catch (Exception ex) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
        }
        return true;
    }

    public boolean clear() { //очищает коллекцию
        first = null;
        return true;
    }

    public int size() {//возвращает размер коллекции
        int count = 0;
        Noda<T> geting = first;
        if (geting != null)
            count++;
        try {
            while (geting.getBefore() != null) {
                geting = geting.getBefore();
                count++;
            }
        }catch (Exception exception){

        }

        return count;
    }

    public T get(int index) { //возвращает элемент под индексом
        Noda<T> geting = first;
        T result;
        try {
        while (geting.getBefore() != null) {
            geting = geting.getBefore();
        }

            for (int i = 0; i < index; i++) {
                geting = geting.getNext();
            }


            result = geting.getValue();
        } catch (Exception ex) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
        }
        return result;
    }
}
