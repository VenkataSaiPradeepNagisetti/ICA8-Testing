import java.io.IOException;
import java.util.Scanner;

/**
 * This urinals program reads the input file
 * and output is stored in another file which contains the count of free urinals.
 *
 * @author Venkata Sai Pradeep Nagisetti
 * @version 1.0
 */
public class urinals {
    public static void main(String[] args) throws IOException {
        countUrinals counts = new countUrinals();
        while (true) {
            System.out.println("\nChoose the type of input");
            System.out.println("1. Keyboard input");
            System.out.println("2. Reading File");
            System.out.println("3. Close");
            System.out.print("Select: ");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();

            if (s1.equals("1")) {
                System.out.print("Enter String pattern of Urinals : ");
                String s = scanner.nextLine();

                if (!counts.goodString(s)) {
                    System.out.println("Enter valid input");
                    continue;
                }

                int count = counts.getCountOfUrinals(s);
                System.out.print("Free Urinals: " + count + "\n");
            } else if (s1.equals("2")) {
                String[] lines = counts.readingFile("src/urinal.dat");
                counts.writingFile(lines);

            } else if (s1.equals("3")) {
                System.out.println("Closed..");
                System.exit(1);
            }
        }
    }


}
