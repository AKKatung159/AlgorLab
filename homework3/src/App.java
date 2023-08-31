import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Grab[] grabs = new Grab[5];
        try {
            int index = 1;
            while (true) {
                Character[] tmpArray;
                int tempK;
                // File fileTest = new File("./testCase/normal/3.1." + index + ".txt");
                // File fileTest = new File("./testCase/normal/3.2." + index + ".txt");
                // File fileTest = new File("./testCase/normal/3.3." + index + ".txt");
                File fileTest = new File("./testCase/Extra/3.4." + index + ".txt");
                // File fileTest = new File("./testCase/Extra/3.5." + index + ".txt");
                Scanner inputScanner = new Scanner(fileTest);
                String data = inputScanner.nextLine();
                tempK = inputScanner.nextInt();
                tmpArray = new Character[data.length()];
                for (int i = 0; i < data.length(); i++) {
                    tmpArray[i] = data.charAt(i);
                }
                Grab tmpGrab = new Grab(tmpArray, tempK);
                grabs[index - 1] = tmpGrab;
                inputScanner.close();
                index++;
            }

        } catch (Exception e) {
            System.out.println("Done");
        }
        for (int i = 0; i < grabs.length; i++) {
            if (grabs[i] != null) {
                System.out.println(grabs[i]);
                System.out.println("Greedy output :\t" + grabs[i].greedySol());
                System.out.println("Brute force output :\t" + grabs[i].bruteForceEntry());
            }
        }
    }
}