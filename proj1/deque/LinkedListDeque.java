package deque;

public class LinkedListDeque<T> implements Deque<T>{

    private int size;

    /* The first item (if it exists) is at sentinel next. */
    private Node sentFront;
    private Node sentBack;

    public class Node {
        public T item;
        public Node prev;
        public Node next;


        public Node() {
        }

        public Node(Node prev, Node next, T item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    public LinkedListDeque() {
        sentFront = new Node();
        sentBack = new Node();
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }

//    public LinkedListDeque(int capacity) {
//        LinkedListDeque lld = new LinkedListDeque();
//        while (capacity != 0) {
//            lld.addLast(0);
//            capacity--;
//        }
//        this = lld;
//    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    @Override
    public void addFirst(T item) {
        Node previousNext = sentFront.next;
        sentFront.next = new Node(sentFront, sentFront.next, item);
        previousNext.prev = sentFront.next;
        size++;
    }


    /**
     * Add an item of type T to the last of the deque.
     * @param item
     */
    @Override
    public void addLast(T item) {
        Node previousPrev = sentBack.prev;
        sentBack.prev = new Node(sentBack.prev, sentBack, item);
        previousPrev.next = sentBack.prev;
        size++;
    }



    /**
     * returns the number of items in the deque.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque() {
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T removeItem = sentFront.next.item;
        sentFront.next = sentFront.next.next;
        sentFront.next.prev = sentFront;
        size -= 1;

        return removeItem;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return  null;
        }
        T removeItem = sentBack.prev.item;
        sentBack.prev = sentBack.prev.prev;
        sentBack.prev.next = sentBack;
        size -= 1;

        return removeItem;
    }

    /**
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        Node p = this.sentFront.next;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }
}
