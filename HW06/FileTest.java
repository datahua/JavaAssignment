import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTest {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        String word = args[1];

        File filein = new File(fileName);
        Scanner fileScan = null;

        try {
            fileScan = new Scanner(filein);
            int lineCount = 0;
            System.out.printf("lines in %s: contains %s:\n",
                    args[0], args[1]);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();

                if (line.contains(word)) {
                    System.out.println(lineCount + ": " + line);
                }
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }
}