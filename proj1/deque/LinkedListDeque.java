package deque;

public class LinkedListDeque<Item> {
    /** Define class LinkedList */
    private class LinkedList {
        public Item item;
        public LinkedList next;
        public LinkedList prev;

        public LinkedList(Item item, LinkedList next, LinkedList prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private LinkedList sentinel = null;
    private int size;
    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new LinkedList(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item(not null) to the front of the deque. */
    public void addFirst(Item item) {
        LinkedList first = new LinkedList(item, sentinel.next, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    /** Adds an item(not null) to the back of the deque. */
    public void addLast(Item item) {
        LinkedList last = new LinkedList(item, sentinel, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last. */
    public void printDeque() {
        LinkedList p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exits, returns null.
     * */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Item ret = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return ret;
        }
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exits, returns null.
     * */
    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            Item ret = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return ret;
        }
    }
    /** Gets the item at the given index.
     * If no such item exists, returns null.
     * */
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getHelper(index, sentinel.next);
    }
    private Item getHelper(int index, LinkedList p) {
        if (index == 0) {
            return p.item;
        } else {
            return getHelper(index - 1, p.next);
        }
    }

    /** Same as get, but uses recursion */
    public Item getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            LinkedList p = sentinel.next;
            while (index > 0) {
                p = p.next;
                index -= 1;
            }
            return p.item;
        }
    }
}
