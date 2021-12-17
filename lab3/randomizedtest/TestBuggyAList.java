package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> buggy = new BuggyAList();
        AListNoResizing<Integer> list = new AListNoResizing();
        for (int i = 0; i < 3; i++) {
            buggy.addLast(i+3);
            list.addLast(i+3);
        }
        assertEquals(1,1);
        for (int i = 0; i < 3; i++) {
            assertEquals(list.removeLast(), buggy.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                b.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                //System.out.println("size: " + size);
                assertEquals(L.size(), b.size());
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                //System.out.println("getLast" + L.getLast());
                assertEquals(L.getLast(), b.getLast());
            } else if (operationNumber == 3 && L.size() > 0) {
                // removeLast
                //System.out.println("removeLast" + L.removeLast());
                assertEquals(L.removeLast(), b.removeLast());
            }
        }
    }
}
