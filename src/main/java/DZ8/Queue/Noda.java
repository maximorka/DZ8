package DZ8.Queue;

public class Noda<T> {
    private T value;
    private Noda<T> next;

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



}
