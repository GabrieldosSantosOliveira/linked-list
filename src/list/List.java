package list;

public interface List<E> extends Iterable<E> {
    int size();

    void add(E value);

    void remove(int index);

    E get(int index);

    boolean isEmpty();
    void clear();

}
