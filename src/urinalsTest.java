import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class urinalsTest {
    private countUrinals urinal;

    @BeforeEach
    public void setUrinal() {
        urinal = new countUrinals();
    }

    //tests for goodString
    @Test
    void goodStringOne() {
        System.out.println("TEST ONE goodString EXECUTED");
        assertEquals(true, urinal.goodString("101010"));
    }

    @Test
    void goodStringTwo() {
        System.out.println("TEST TWO goodString EXECUTED");
        assertEquals(false, urinal.goodString(""));
    }

    @Test
    void goodStringThree() {
        System.out.println("TEST THREE goodString EXECUTED");
        assertThrows(NumberFormatException.class, () -> {
            urinal.goodString("XYZ");
        });
    }

    /**
     * Getting count of free urinals Tests
     */
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

    /**
     * Tests for reading file
     */
    @Test
    void readingFileOne() throws IOException {
        System.out.println("TEST ONE readingFile Valid Case EXECUTED");
        String path = "src/urinal.dat";
        assertArrayEquals(new String[]{"10001", "1001", "00000", "0000", "01000", "011"}, urinal.readingFile(path));
    }

    @Test
    void readFromFileTwo() {
        System.out.println("TEST TWO readingFile File does not exist EXECUTED");
        String path = "urinal.dat1";
        assertThrows(FileNotFoundException.class, () -> {
            urinal.readingFile(path);
        });
    }

    @Test
    void readFromFileThree() throws IOException {
        System.out.println("TEST THREE readingFile Empty file Case EXECUTED");
        String path = "src/urinal.dat";
        String [] in = urinal.readingFile(path);
        assertArrayEquals(in, urinal.readingFile(path));
    }

    @Test
    void readFromFileFour() {
        System.out.println("TEST FOUR readingFile Valid Case EXECUTED");
        String path = "urinal";
        assertThrows(IOException.class, () -> {
            urinal.readingFile(path);
        });
    }

    /**
     * Tests for writing file
     */
    @Test
    void writingFile() {
        System.out.println("TEST ONE writingFile EXECUTED - Exception case");
        assertThrows(Exception.class, () -> {
            urinal.writingFile(new String[]{"abc", "1001", "00000", "0000", "01000", "011"});
        });
    }

    @Test
    void writeToFileTwo() throws IOException {
        System.out.println("TEST TWO writingFile EXECUTED - Valid case");
        // does not throw any error
        urinal.writingFile(new String[]{"10001", "1001", "00000", "0000", "01000", "011"});
    }



}
