import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class countUrinals {
    //check to see good String
    Boolean goodString(String s){
        if (s.trim().length() == 0)
            return false;
        Pattern pat = Pattern.compile("^[0-1]*$");
        if (!pat.matcher(s).matches()) {
            throw new NumberFormatException("String Invalid");
        }
        return pat.matcher(s).find();
    }

    /**
     *
     * @param freeUrinalsCount
     * @return count of free urinals
     */
    int getCountOfUrinals(String freeUrinalsCount) {
        Pattern pat = Pattern.compile("11");
        Matcher match = pat.matcher(freeUrinalsCount);
        if (match.find()) return -1;

        int previoustrack = (int) freeUrinalsCount.chars().filter(ch -> ch == '1').count();

        int[] arrUrinal = new int[freeUrinalsCount.length()];
        for (int i = 0; i < freeUrinalsCount.length(); i++) {
            arrUrinal[i] = Character.getNumericValue(freeUrinalsCount.charAt(i));
        }
        for (int i = 0; i < arrUrinal.length; i++) {
            int in = arrUrinal[i];
            if (i == 0) {
                if (arrUrinal.length == 1) {
                    return 1 - Integer.parseInt(String.valueOf(in));
                } else if ((in == 0) && arrUrinal[i + 1] == 0) {
                    arrUrinal[i] = 1;
                }
            } else if (i == arrUrinal.length - 1) {
                if (in == 0 && arrUrinal[i - 1] == 0) {
                    arrUrinal[i] = 1;
                }
            } else {
                if (in == 0 && arrUrinal[i - 1] == 0 && arrUrinal[i + 1] == 0) {
                    arrUrinal[i] = 1;
                }
            }
        }
        return (int) Arrays.stream(arrUrinal).filter(x -> x == 1).count() - previoustrack;
    }

    String[] readingFile(String path) throws IOException {
        List<String> in = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String text = bf.readLine();
        while (text != null) {
            in.add(text);
            text = bf.readLine();
        }
        bf.close();
        return in.toArray(new String[0]);
    }

    void writingFile(String[] info) throws IOException {
        String outFileName = writeToOutput();
        File outputFile = new File("./" + outFileName);
        StringBuilder output = new StringBuilder();
        for (String text : info) {
            if (goodString(text))
                output.append(this.getCountOfUrinals(text)).append("\n");
        }
        Files.write(outputFile.toPath(), output.toString().getBytes());
        System.out.println("Output written to " + outFileName);
    }
    String writeToOutput() {
        File fl = new File("./rule.txt");
        if (!fl.exists()) return "rule.txt";
        File Fl = new File("./");
        File[] s = Fl.listFiles();
        int c = 0;
        assert s != null;
        for (File x : s) {
            if (x.isFile()) {
                String fileName = x.getName();
                if (fileName.contains("rule")) c ++;
            }
        }
        return "rule" + c + ".txt";
    }
}
