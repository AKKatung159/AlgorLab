import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        File[] fileTest;
        int numOfPoints;
        float[][] point;
        Triangulation[] triangulations = new Triangulation[8];
        try {
            File file1 = new File("./testCase/1.1.txt");
            File file2 = new File("./testCase/1.2.txt");
            File file3 = new File("./testCase/2.1.txt");
            File file4 = new File("./testCase/2.2.txt");
            File file5 = new File("./testCase/3.txt");
            File file6 = new File("./testCase/4.txt");
            File file7 = new File("./testCase/5 Extra.txt");
            File file8 = new File("./testCase/6 Extra.txt");
            fileTest = new File[] { file1, file2, file3, file4, file5, file6, file7, file8 };
            for (int i = 0; i < fileTest.length; i++) {
                Scanner inputScanner = new Scanner(fileTest[i]);
                numOfPoints = inputScanner.nextInt();
                point = new float[numOfPoints][2];
                for (int j = 0; j < numOfPoints; j++) {
                    point[j][0] = inputScanner.nextFloat();
                    point[j][1] = inputScanner.nextFloat();
                }
                triangulations[i] = new Triangulation(numOfPoints, point);
                inputScanner.close();
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Done");
        }
        for (Triangulation triangulation : triangulations) {
            System.out.println(triangulation);
            System.out.println("====================================");
        }
    }
}

//unsorted
//Minimum cost : 41.546303
// Minimum cost : 89.70813
// Minimum cost : 57.606106
// Minimum cost : 52.33978
// Minimum cost : 27.275375
// Minimum cost : 15.772699
// Minimum cost : 89.480644
// Minimum cost : 365.84393

//sorted
// Minimum cost : 41.546303
// Minimum cost : 89.70813
// Minimum cost : 57.606106
// Minimum cost : 52.33978
// Minimum cost : 27.275375
// Minimum cost : 15.300563
// Minimum cost : 89.48064
// Minimum cost : 365.84393