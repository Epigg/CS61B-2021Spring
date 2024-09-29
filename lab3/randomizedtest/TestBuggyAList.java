package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correctList = new AListNoResizing<>();
        BuggyAList<Integer> buggyList = new BuggyAList<>();
        correctList.addLast(4);
        correctList.addLast(5);
        correctList.addLast(6);
        buggyList.addLast(4);
        buggyList.addLast(5);
        buggyList.addLast(6);
        for (int i = 0; i < 3; i += 1) {
            int x = correctList.removeLast();
            int y = buggyList.removeLast();
            assertEquals(x, y);
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                // System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = correct.size();
                int size2 = broken.size();
                // System.out.println("size1: " + size1 + ", size2: " + size2);
                assertEquals(size1, size2);
            } else if (correct.size() > 0) {
                if (operationNumber == 2) {
                    // getLast
                    int last1 = correct.getLast();
                    int last2 = broken.getLast();
                    // System.out.println("getLast1: " + last1 + ",getLast2: " + last2);
                    assertEquals(last1, last2);
                } else if (operationNumber == 3) {
                    // removeLast
                    int last1 = correct.removeLast();
                    int last2 = broken.removeLast();
                    // System.out.println("removeLast1: " + last1 + ",removeLast2: " + last2);
                    assertEquals(last1, last2);
                }
            }
        }
    }
}
