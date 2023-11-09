import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int number = 0;
        int[] arr;
        try {
            File file = new File("src/testCase/example.txt");
            Scanner sc = new Scanner(file);
            number = sc.nextInt();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("number: " + number);
        arr = new int[number+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        Sort sort = new Sort(arr);
        // System.out.println(sort.toString(null));
        // System.out.println(sort.toString(sort.sortNotDivideAndConQuer()));
        System.out.println(sort.toString(sort.sortDivideAndConQuer()));
        sort.generateSwapCombinations(arr, 0);
        // System.out.println(sort.toString(sort.sortDivideAndConQuer()));
    }
}