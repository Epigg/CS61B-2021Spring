package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> toTest = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<Integer>();

        StringBuilder message = new StringBuilder();

        int times = 1000;
        for (int i = 0; i < times; i++) {
            double decision = StdRandom.uniform(7);
            if (decision == 0) {
                toTest.addFirst(i);
                solution.addFirst(i);
                message.append("addFirst(" + i + ")\n");
            } else if (decision == 1) {
                toTest.addLast(i);
                solution.addLast(i);
                message.append("addLast(" + i + ")\n");
            } else if (decision == 2) {
                boolean x = toTest.isEmpty();
                boolean y = solution.isEmpty();
                message.append("isEmpty()\n");
                assertEquals(message.toString(), x, y);
            } else if (decision == 3) {
                Integer x = toTest.size();
                Integer y = solution.size();
                message.append("size()\n");
                assertEquals(message.toString(), x, y);
            } else if (!toTest.isEmpty() && !solution.isEmpty()) {
                if (decision == 4) {
                    Integer x = toTest.removeFirst();
                    Integer y = solution.removeFirst();
                    message.append("removeFirst()\n");
                    assertEquals(message.toString(), x, y);
                } else if (decision == 5) {
                    Integer x = toTest.removeLast();
                    Integer y = solution.removeLast();
                    message.append("removeLast()\n");
                    assertEquals(message.toString(), x, y);
                } else if (decision == 6) {
                    int maxIndex = Math.min(toTest.size(), solution.size());
                    int index = StdRandom.uniform(maxIndex);
                    Integer x = toTest.get(index);
                    Integer y = solution.get(index);
                    message.append("get(" + index + ")\n");
                    assertEquals(message.toString(), x, y);
                }
            }
        }
    }
}
