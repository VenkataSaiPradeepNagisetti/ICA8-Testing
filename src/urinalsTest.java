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
}
