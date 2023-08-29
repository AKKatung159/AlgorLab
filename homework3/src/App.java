import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Grab[] grabs=new Grab[5];
        try {
        int index = 1;
        while (true) {
        Character[] tmpArray;
        int tempK;
        File fileTest = new File("./testCase/normal/3.1." + index + ".txt");
        // File fileTest = new File("./testCase/normal/3.2." + index + ".txt");
        // File fileTest = new File("./testCase/normal/3.3." + index + ".txt");
        // File fileTest = new File("./testCase/Extra/3.4." + index + ".txt");
        // File fileTest = new File("./testCase/Extra/3.5." + index + ".txt");
        Scanner inputScanner = new Scanner(fileTest);
        String data = inputScanner.nextLine();
        tempK=inputScanner.nextInt();
        tmpArray = new Character[data.length()];
        for (int i = 0; i < data.length(); i++) {
        tmpArray[i]=data.charAt(i);
        }
        Grab tmpGrab=new Grab(tmpArray, tempK);
        grabs[index-1]=tmpGrab;
        inputScanner.close();
        index++;
        }

        } catch (Exception e) {
        System.out.println("Done");
        }
        for (int i = 0; i < grabs.length; i++) {
        System.out.println(grabs[i]);
        System.out.println("Greedy output :\t"+grabs[i].greedySol());
        System.out.println("Brute force output :\t"+grabs[i].bruteForceEntry());
        }

        // Character arr1[] = { 'G', 'P', 'P', 'G', 'P' };
        // int k1 = 1;
        // System.out.println("ans"+new Grab(arr1, k1).greedySol()); // Output: 2
        // System.out.println("ans"+new Grab(arr1, k1).bruteForceEntry()); // Output: 2

        // Character arr2[] = { 'P', 'P', 'G', 'G', 'P', 'G' };
        // int k2 = 2;
        // System.out.println("ans"+new Grab(arr2, k2).greedySol()); // Output: 3
        // System.out.println("ans"+new Grab(arr2, k2).bruteForceEntry()); // Output: 3

        // Character arr3[] = { 'G', 'P', 'G', 'P', 'P', 'G' };
        // int k3 = 3;
        // System.out.println("ans"+new Grab(arr3, k3).greedySol()); // Output: 3
        // System.out.println("ans"+new Grab(arr3, k3).bruteForceEntry()); // Output: 3
    }
}