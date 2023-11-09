import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        StringMatching sm=null;
        try {
            File file = new File("src/testCase/example.txt");
            Scanner sc = new Scanner(file);

            String[] setStrings = sc.nextLine().split(" ");
            // System.out.println(setStrings[0]+setStrings[1]+setStrings[2]);

            int numPatterns = sc.nextInt();
            int numText = sc.nextInt();
            // System.out.println(numPatterns);
            // System.out.println(numText);

            String[] patterns= new String[numPatterns];
            String[] text = new String[numText];
            for (int i = 0; i < numPatterns; i++) {
                patterns[i] = sc.next();
            }
            for (int i = 0; i < numText; i++) {
                text[i] = sc.next();
            }
            sm = new StringMatching(setStrings, numPatterns, numText, patterns, text);
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(sm);
    }
}
