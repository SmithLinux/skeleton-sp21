package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        IntList lst2 = IntList.of(7);
        IntList lst3 = IntList.of(7, 7, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        boolean changed2 = IntListExercises.squarePrimes(lst2);
        boolean changed3 = IntListExercises.squarePrimes(lst3);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertEquals("49", lst2.toString());
        assertEquals("49 -> 49 -> 49", lst3.toString());
        assertTrue(changed);
        assertTrue(changed2);
        assertTrue(changed3);
    }
}
