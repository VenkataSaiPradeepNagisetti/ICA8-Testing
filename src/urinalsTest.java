import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class urinalsTest {
    private urinals urinal;

    @BeforeEach
    public void setUrinal() {
        urinal = new urinals();
    }

    @Test
    void goodStringOne() {
        assertEquals(true, urinal.goodString("======== Venkata Sai Pradeep Nagisetti == TEST ONE EXECUTED ======="));
    }

    @Test
    void goodStringTwo() {
        assertEquals(false, urinal.goodString("======== Venkata Sai Pradeep Nagisetti == TEST TWO EXECUTED ======="));
    }
}
