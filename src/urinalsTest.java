import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class urinalsTest {
    private urinals urinal;

    @BeforeEach
    public void setUrinal() {
        urinal = new urinals();
    }

    //tests for goodString
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

    // tests for getCountOfUrinals
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

    //tests for readingFile
    @Test
    void readingFileOne() {
        System.out.println("TEST ONE readingFile Valid case EXECUTED");
        String path = "urinal.dat"
        assertEquals(new String[]{"10001","1001","00000","0000","01000","011"}, urinal.readingFile(path));
    }

    @Test
    void readingFileTwo() {
        System.out.println("TEST TWO readingFile File does not exist EXECUTED");
        String path = "urinal.datx"
        assertThrows(FileNotFoundException.class, () -> {
          urinal.readingFile(path);
        });
    }

    @Test
    void readingFileThree() {
        System.out.println("TEST THREE readingFile Empty file EXECUTED");
        String path = "urinal.dat"
        assertEquals(new String[]{}, urinal.readingFile(path));
    }

    @Test
    void readingFileFour() {
        System.out.println("TEST FOUR readingFile  IOException EXECUTED");
        String path = "urine"
        assertThrows(IOException.class, () -> {
           urinal.readingFile(path);
        });
    }

}
