import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        GraphVertexCover g=null;
        GraphVertexCoverApp g2=null;
        Reduce3SAT r=null;
        try {
            File file = new File("src/testCase/example.txt");
            Scanner sc = new Scanner(file);
            int k = sc.nextInt();
            sc.nextLine();
            String[] temp = sc.nextLine().split(" ");
            int n = temp.length;
            int[][] adjMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                adjMatrix[0][i] = Integer.parseInt(temp[i]);
            }
            for (int i = 1; i < n; i++) {
                temp = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    adjMatrix[i][j] = Integer.parseInt(temp[j]);
                }
            }
            g = new GraphVertexCover(k, adjMatrix);
            g2 = new GraphVertexCoverApp(adjMatrix);
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        int[][] clauses = {{1,-2,3}};
        r = new Reduce3SAT(clauses, 3);
        // System.out.println(new GraphVertexCover(5,r.convertToAdjacencyMatrix()));
        System.out.println(r.toString());
        System.out.println(g.toString());
        System.out.println(g2.toString());
    }
}