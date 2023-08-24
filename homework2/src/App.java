import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Graph[] graphs = new Graph[100];
        try {
            int index = 1;
            while (true) {
                String testCase = "";
                // File fileTest = new File("./testCase/1.Regular/2.1." + index + ".txt");
                File fileTest = new File("./testCase/2.Extra/2.2." + index + ".txt");
                try (Scanner idk = new Scanner(fileTest)) {
                    while (idk.hasNextLine()) {
                        testCase += idk.nextLine() + "\n";
                    }
                }
                String[] rows = testCase.split("\n");
                int[][] matrix = new int[rows.length][rows.length];
                for (int i = 0; i < rows.length; i++) {
                    String[] elements = rows[i].split(" ");
                    for (int j = 0; j < elements.length; j++) {
                        matrix[i][j] = Integer.parseInt(elements[j]);
                    }
                }
                graphs[index - 1] = new Graph(matrix);
                index++;
            }

        } catch (Exception e) {
            System.out.println("Done");
        }
        int check = 3;
        System.out.println(graphs[check].toString());
        // graphs[check].printGraph();
        graphs[check].hamilCheck();
        // graphs[3].forestGump();
        // graphs[check].printAllPaths();

        // graphs[check].findAndCompleteCycle();
        System.out.println(graphs[check].path);
        // System.out.println(graphs[check].allPath);
    }
}
