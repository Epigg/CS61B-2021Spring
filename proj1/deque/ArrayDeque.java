package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int head;
    private int tail;

    /** Creates an empty Array deque. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        head = 0; // index before the front of the deque
        tail = 1; // index after the back of the deque
    }

    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];
        if (head < tail) {
            System.arraycopy(items, head + 1, newItems, 1, size);
        } else {
            System.arraycopy(items, head + 1, newItems, 1, items.length - 1 - head);
            System.arraycopy(items, 0, newItems, items.length - head, size - (items.length - 1 - head));
        }
        head = 0;
        tail = size + 1;
        items = newItems;
    }
    /** Adds an item(not null) to the front of the deque. */
    public void addFirst(Item item) {
        if (head == tail) {
            resize(items.length * 2);
        }
        items[head] = item;
        size += 1;
        head = (head - 1) % items.length;
    }

    /** Adds an item(not null) to the back of the deque. */
    public void addLast(Item item) {
        if (head == tail) {
            resize(items.length * 2);
        }
        items[tail] = item;
        size += 1;
        tail = (tail + 1) % items.length;
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
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exits, returns null.
     * */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        } else if (size < items.length / 4 && size > 2) {
            resize(items.length / 2);
        }
        head = (head + 1) % items.length;
        Item ret = items[head];
        items[head] = null;
        size -= 1;
        return ret;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exits, returns null.
     * */
    public Item removeLast() {
        if (size == 0) {
            return null;
        } else if (size < items.length / 4 && size > 4) {
            resize(items.length / 2);
        }
        tail = (tail - 1) % items.length;
        Item ret = items[tail];
        items[tail] = null;
        size -= 1;
        return ret;
    }

    /** Gets the item at the given index.
     * If no such item exists, returns null.
     * */
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(index + head + 1) % items.length];
    }
}
