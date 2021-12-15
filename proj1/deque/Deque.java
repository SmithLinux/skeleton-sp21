package deque;

public interface Deque<T> {
    void addFirst(T item);

    void addLast(T item);


    int size();

    void printDeque();

    // Remove the First item, if no such item exists, return null.
    T removeFirst();

    // Remove the Last item, if no such item exists, return null.
    T removeLast();

    // Return the item at the given index, if no such item exists, return null.
    T get(int index);

    default boolean isEmpty() {
        if (size() > 0) {
            return false;
        } else {
            return true;
        }
    };
}
