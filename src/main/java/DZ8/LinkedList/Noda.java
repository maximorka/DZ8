package DZ8.LinkedList;

public class Noda<T> {
    private T value;
    private Noda<T> next;
    private Noda<T> before;

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Noda{}";
    }

    public void setValue(T value) {
        this.value = value;

    }

    public Noda<T> getNext() {
        return next;
    }

    public void setNext(Noda<T> next) {
        this.next = next;
    }

    public Noda<T> getBefore() {
        return before;
    }

    public void setBefore(Noda<T> before) {
        this.before = before;
    }

}
