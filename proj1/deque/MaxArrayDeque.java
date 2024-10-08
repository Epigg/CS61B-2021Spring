package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    /* The final keyword means that the variable cannot
     * be reassigned after its initial value is set. */
    private final Comparator<T> comparator;

    /** Creates a MaxArrayDeque with the given Comparator. */
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    /** Returns the maximum element in the deque
     * as governed by the previously given Comparator.
     * If the MaxArrayDeque is empty, simply return null. */
    public T max() {
        return max(comparator);
    }

    /** Returns the maximum element in the deque
     * as governed by the parameter Comparator c.
     * If the MaxArrayDeque is empty, simply return null. */
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T retMax = this.get(0);
        for (int i = 0; i < this.size(); i += 1) {
            if (c.compare(this.get(i), retMax) > 0) {
                retMax = this.get(i);
            }
        }
        return retMax;
    }
}
