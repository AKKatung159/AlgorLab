import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int numOfPlaces;
        int numOfRoads;
        int[][] Graph;
        Graph[] Graphs = new Graph[10];
        try {
            File file = new File("src/testCase/6.1.txt");
            Scanner inputScanner = new Scanner(file);
            int i = 0;
            while (inputScanner.hasNextLine()) {
                numOfPlaces = inputScanner.nextInt();
                numOfRoads = inputScanner.nextInt();
                if (numOfPlaces == 0 && numOfRoads == 0) {
                    break;
                }
                Graph = new int[numOfPlaces][numOfPlaces];
                for (int j = 0; j < numOfRoads; j++) {
                    int a = inputScanner.nextInt()-1;
                    int b = inputScanner.nextInt()-1;
                    int c = inputScanner.nextInt();
                    if (c == 2) {
                        Graph[a][b] = 1;
                        Graph[b][a] = 1;
                    }
                    if (c == 1) {
                        Graph[a][b] = 1;
                    }
                    // System.out.println(j);
                }
                Graphs[i] = new Graph(Graph);
                i++;
            }
            inputScanner.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("File not found");
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(Graphs[i]);
            System.out.print("Answer : "+Graphs[i].isStronglyConnected()+"\n");
            System.out.print(Graphs[i].findCyclePath()+"\n");
        }
    }
}
