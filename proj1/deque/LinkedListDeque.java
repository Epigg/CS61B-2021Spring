package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    /** Define class LinkedList */
    private class LinkedList {
        // Here use private modifier rather than public.
        private T item;
        private LinkedList next;
        private LinkedList prev;

        LinkedList(T item, LinkedList next, LinkedList prev) {
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
    @Override
    public void addFirst(T item) {
        LinkedList first = new LinkedList(item, sentinel.next, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    /** Adds an item(not null) to the back of the deque. */
    @Override
    public void addLast(T item) {
        LinkedList last = new LinkedList(item, sentinel, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last. */
    @Override
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
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T ret = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return ret;
        }
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exits, returns null.
     * */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T ret = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return ret;
        }
    }

    /** Gets the item at the given index.
     * If no such item exists, returns null.
     * */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getHelper(index, sentinel.next);
    }
    private T getHelper(int index, LinkedList p) {
        if (index == 0) {
            return p.item;
        } else {
            return getHelper(index - 1, p.next);
        }
    }

    /** Same as get, but uses recursion */
    public T getRecursive(int index) {
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

    /** Returns an iterator. */
    public Iterator<T> iterator() {
        return new LinkedDequeIterator();
    }

    private class LinkedDequeIterator implements Iterator<T> {
        private int index;

        LinkedDequeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public T next() {
            T retNext = get(index);
            index += 1;
            return retNext;
        }
    }

    /** Returns whether the parameter o is equal to the Deque. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o == this) {
            return true;
        } else if (o.getClass() != this.getClass()) {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (other.size != this.size) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if(other.get(i) != this.get(i)) {
                return false;
            }
        }
        return true;
    }
}
