import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int numOfTown;
        int numOfRoad;
        int numOfAns;
        Graph g=null;
        int[][] Graph;
        int[][] ans=null;
        try{
            File file = new File("src/testCase/example.txt");
            Scanner sc = new Scanner(file);
            numOfTown=sc.nextInt();
            numOfRoad=sc.nextInt();
            numOfAns=sc.nextInt();
            Graph = new int[numOfTown][numOfTown];
            for (int i = 0; i < numOfRoad; i++) {
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                int c = sc.nextInt();
                Graph[a][b] = c;
                Graph[b][a] = c;
            }
            ans = new int[numOfAns][2];
            for (int i = 0; i < numOfAns; i++) {
                ans[i][0] = sc.nextInt()-1;
                ans[i][1] = sc.nextInt()-1;
            }
            g = new Graph(Graph);
            sc.close();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(g);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("From "+(ans[i][0]+1)+" to "+(ans[i][1]+1));
            // System.out.println("Weight : "+ g.findQuietestPaths()[ans[i][0]][ans[i][1]]);
            System.out.println("Weight : "+g.findQuietestPaths(ans[i][0], ans[i][1]));
            // System.out.println(g.findQuietestPaths(0, 20));
            System.out.println("Path : "+g.reconstructPath(ans[i][0], ans[i][1])+"\n");
        }
    }
}
