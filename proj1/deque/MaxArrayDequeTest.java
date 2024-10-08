package deque;

import java.util.Comparator;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    public static class SquareC implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            // auto-unboxing
            int x = o1;
            int y = o2;
            return x * x - y * y;
        }
    }
    public static class PolynomialC implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int x = o1;
            int y = o2;
            return (x * x - 4 * x) - (y * y - 4 * y);
        }
    }

    @Test
    public void test() {
        Comparator<Integer> c1 = new SquareC();
        Comparator<Integer> c2 = new PolynomialC();
        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<Integer>(c1);
        for (int i = -1 ; i < 4; i += 1) {
            mad1.addLast(i);
        }
        int max1 = mad1.max();
        int max2 = mad1.max(c2);
        assertEquals(3, max1);
        assertEquals(-1, max2);
    }
}
