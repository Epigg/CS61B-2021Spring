package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;

    /** Creates an empty Array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        head = items.length - 1; // index before the front of the deque
        tail = 0; // index after the back of the deque
    }

    /** Resize the length of items to the newSize and the front is at index 0. */
    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        int firstIndex = (head + 1) % items.length;
        int lastIndex = (tail + items.length - 1) % items.length;
        if (firstIndex > lastIndex) {
            System.arraycopy(items, firstIndex, newItems, 0, items.length - firstIndex);
            System.arraycopy(items, 0, newItems, items.length - firstIndex, lastIndex + 1);
        } else {
            System.arraycopy(items, firstIndex, newItems, 0, size);
        }
        head = newItems.length - 1;
        tail = size;
        items = newItems;
    }

    /** Adds an item(not null) to the front of the deque. */
    @Override
    public void addFirst(T t) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[head] = t;
        size += 1;

        /* "head = (head - 1) % items.length;" is not correct,
         * as "-1 % items.length == -1" not "items.length - 1". */
        head = (head + items.length - 1) % items.length;
    }

    /** Adds an item(not null) to the back of the deque. */
    @Override
    public void addLast(T t) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[tail] = t;
        size += 1;
        tail = (tail + 1) % items.length;
    }

    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
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
        } else if (size < items.length / 4 && size > 2) {
            resize(items.length / 2);
        }
        head = (head + 1) % items.length;
        T ret = items[head];
        items[head] = null;
        size -= 1;
        return ret;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exits, returns null.
     * */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size < items.length / 4 && size > 4) {
            resize(items.length / 2);
        }
        tail = (tail + items.length - 1) % items.length;
        T ret = items[tail];
        items[tail] = null;
        size -= 1;
        return ret;
    }

    /** Gets the item at the given index.
     * If no such item exists, returns null.
     * */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(index + head + 1) % items.length];
    }

    /** Returns an iterator. */
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        /* Style: the public modifier here is redundant as members of a private nested
         * class in Java do not need (and cannot have) the public modifier.
         */

        ArrayDequeIterator() {
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
        } else if (!(o instanceof Deque)) {
            return false;
        }

        Deque<T> other = (Deque<T>) o;
        if (other.size() != this.size) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (other.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }
}
