package JUnit_Excercises;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    Calculator c = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(10, c.add(7, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, c.subtract(10, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(20, c.multiply(4, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(5, c.divide(20, 4));
    }
}

