package deque;

public class ArrayDeque<T> implements Deque<T> {

    private int size;
    private T item[];
    private int itemFirst;
    private int itemLast;

    public ArrayDeque() {
        this.item = (T[]) new Object[10];
        this.size = 0;
        this.itemFirst = item.length / 2 - 1;
        this.itemLast = item.length / 2;
    }

    public ArrayDeque(int capacity) {
        this.item = (T[]) new Object[capacity];
        this.size = 0;
        this.itemFirst = item.length / 2 - 1;
        this.itemLast = item.length / 2;
    }

    // resize the arrayDeque.
    private void resize() {
        T[] a = null;
        int firstTotal = 0;
        int lastTotal = 0;
        if ((size / (double)item.length) < 0.25 && item.length > 39) {
            a = (T[]) new Object[(int) item.length / 2];
            System.out.println(size + " itemFirst" + itemFirst + " itemLast" + itemLast);
            System.arraycopy(item, this.itemFirst, a, this.itemFirst / 2, size + 1);
            itemFirst = itemFirst / 2;
            itemLast = itemLast / 2;
            this.item = a;
        }else if (this.size == this.item.length) {
            a = (T[]) new Object[(int) (item.length * 2)];
            if (itemLast < (size / 2 + 1)) {
                System.arraycopy(item, item.length / 2, a, a.length / 2, item.length - itemLast);
                System.arraycopy(item, 0, a, a.length / 2 + item.length - itemLast, itemLast);
                this.itemFirst = a.length / 2 - (item.length / 2 - itemLast) - 1;
                this.itemLast = a.length / 2 + itemLast + item.length / 2 - 1;
                if (itemLast == a.length - 1) {
                    itemLast = 0;
                }
            } else if (itemFirst > (size / 2)) {
                System.arraycopy(item, 0, a, a.length / 2 - item.length / 2, itemLast);
                System.arraycopy(item, itemFirst, a, a.length / 2 + (itemLast - item.length / 2), item.length - itemFirst);
                this.itemFirst = a.length / 2 - item.length / 2 - item.length - itemFirst;
                this.itemLast = a.length / 2 + (item.length / 2 - itemLast);
            } else {
                System.arraycopy(item, this.itemFirst, a, a.length / 2 - item.length / 2, size + 1);
                this.itemFirst = a.length / 2 - itemFirst;
                this.itemLast = a.length / 2 + (item.length / 2 - itemLast);
            }

            this.item = a;
        }

    }

    // Add item to the first of the deque.
    @Override
    public void addFirst(T item) {
        if (this.size == this.item.length) {
            resize();
        }
        this.item[itemFirst] = item;
        if (itemFirst == 0) {
            itemFirst = this.item.length - 1;
        } else {
            this.itemFirst -= 1;
        }
        this.size++;
    }

    // Add item to the last of the deque.
    @Override
    public void addLast(T item) {
        if (this.size == this.item.length) {
            resize();
        }
        this.item[itemLast] = item;
        if (itemLast == this.item.length - 1) {
            itemLast = 0;
        } else {
            this.itemLast += 1;
        }
        this.size++;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {

    }

    // Remove the First item, if no such item exists, return null.
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            if (((double)size / item.length) < 0.25) {
                resize();
            }
            if (itemFirst == (item.length - 1)) {
                itemFirst = 0;
            }
            itemFirst += 1;
            T removeItem = item[itemFirst];
            item[itemFirst] = null;
            size -= 1;

            return removeItem;
        }
    }

    // Remove the Last item, if no such item exists, return null.
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            if (((double)size / item.length) < 0.25) {
                resize();
            }
            if (itemLast == 0) {
                itemLast = item.length - 1;
            }
            itemLast -= 1;
            T removeItem = item[itemLast];
            item[itemLast] = null;
            size -= 1;

            return removeItem;
        }
    }

    // Return the item at the given index, if no such item exists, return null.
    @Override
    public T get(int index) {
        return item[index];
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        } else {
            return true;
        }
    }
}
