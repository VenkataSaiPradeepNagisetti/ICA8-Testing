import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class urinalsTest {
    private urinals urinal;

    @BeforeEach
    public void setUrinal() {
        urinal = new urinals();
    }

    @Test
    void goodStringOne() {
        System.out.println("TEST ONE goodString EXECUTED"));
        assertEquals(true, urinal.goodString("101010"));
    }

    @Test
    void goodStringTwo() {
        System.out.println("TEST TWO goodString EXECUTED"));
        assertEquals(false, urinal.goodString(""));
    }

    @Test
    void goodStringThree() {
        System.out.println("TEST THREE goodString EXECUTED");
        assertThrows(NumberFormatException.class, () -> {
            urinal.goodString("XYZ");
        });
    }

    @Test
    void getCountOfUrinalsOne() {
        System.out.println("TEST ONE getCountOfUrinals EXECUTED");
        assertEquals(1, urinal.getCountOfUrinals("10001"));
    }

    @Test
    void getCountOfUrinalsTwo() {
        System.out.println("TEST TWO getCountOfUrinals EXECUTED");
        assertEquals(0, urinal.getCountOfUrinals("1001"));
    }

    @Test
    void getCountOfUrinalsThree() {
        System.out.println("TEST THREE getCountOfUrinals EXECUTED");
        assertEquals(3, urinal.getCountOfUrinals("00000"));
    }

    @Test
    void getCountOfUrinalsFour() {
        System.out.println("TEST FOUR getCountOfUrinals EXECUTED");
        assertEquals(2, urinal.getCountOfUrinals("0000"));
    }
    @Test
    void getCountOfUrinalsFive() {
        System.out.println("TEST FIVE getCountOfUrinals EXECUTED");
        assertEquals(1, urinal.getCountOfUrinals("01000"));
    }

    @Test
    void getCountOfUrinalsSix() {
        System.out.println("TEST SIX getCountOfUrinals EXECUTED");
        assertEquals(-1, urinal.getCountOfUrinals("011"));
    }


}
