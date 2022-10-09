package flik;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {

    @Test
    public void isSameNumberTest() {
        boolean foo = Flik.isSameNumber(1000,1000);
        assertEquals(true, foo);
    }
}
