import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void Testing_highest_border() {
        double test = Math.sqrt(1 + 0.999999);

        assertEquals(test, Main.zadanie(0.999999, 3), Math.pow(10, 3));
        assertEquals(test, Main.zadanie(0.999999, 4), Math.pow(10, 4));
        assertEquals(test, Main.zadanie(0.999999, 5), Math.pow(10, 5));
        assertEquals(test, Main.zadanie(0.999999, 6), Math.pow (10, 6));
        assertEquals(test, Main.zadanie(0.999999, 7), Math.pow(10, 7));
    }
    @Test
    public void Testing_zero() {
        double test = Math.sqrt(1);

        assertEquals(test, Main.zadanie(0, 3), Math.pow(10, 3));
        assertEquals(test, Main.zadanie(0, 4), Math.pow(10, 4));
        assertEquals(test, Main.zadanie(0, 5), Math.pow(10, 5));
        assertEquals(test, Main.zadanie(0, 6), Math.pow (10, 6));
        assertEquals(test, Main.zadanie(0, 7), Math.pow(10, 7));
    }
    @Test
    public void Testing_lowest_border() {
        double test = Math.sqrt(1 + (-0.999999));

        assertEquals(test, Main.zadanie(-0.999999, 3), Math.pow(10, 3));
    }
}