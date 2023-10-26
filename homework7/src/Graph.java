import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int[][] adjacencyMatrix;
    public int[][] next;

    public Graph(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] row : adjacencyMatrix) {
            for (int cell : row) {
                result.append(cell).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public int[][] findQuietestPaths() {
        int[][] noise = new int[adjacencyMatrix.length][adjacencyMatrix.length];
        next = new int[adjacencyMatrix.length][adjacencyMatrix.length];
    
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                noise[i][j] = (i != j && adjacencyMatrix[i][j] == 0) ? Integer.MAX_VALUE : adjacencyMatrix[i][j];
                next[i][j] = (noise[i][j] != Integer.MAX_VALUE) ? j : -1;
            }
        }
        //set noise maxValue if there is no path between two towns
        //set next -1 if there is no path between two towns

        for (int k = 0; k < adjacencyMatrix.length; k++) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    int alternativePathNoise = Math.max(noise[i][k], noise[k][j]);
                    //เลือกค่ามากสุดจากทั้งสองเส้นทาง i-k, k-j
                    //เลือกเส้นทางที่มีค่า noise น้อยที่สุด
                    if (alternativePathNoise < noise[i][j]) {
                        noise[i][j] = alternativePathNoise;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        return noise;
    }
    public String findQuietestPaths(int i,int j){
        if(i<0||j<0||i>=adjacencyMatrix.length||j>=adjacencyMatrix.length)
            return "Invalid input";
        else
        if(findQuietestPaths()[i][j]==Integer.MAX_VALUE)
            return "No path";
        else if(findQuietestPaths()[i][j]==0)
            return "Same town";
        else
            return Integer.toString(findQuietestPaths()[i][j]);
    }
    
    public List<Integer> reconstructPath(int u, int v) {
        List<Integer> path = new ArrayList<>();
        if (next[u][v] == -1) {
            return path; // no path between u and v
        }
        path.add(u+1);
        while (u != v) {
            u = next[u][v];
            path.add(u+1);
        }
        return path;
    }
    public String printNoise(){
        StringBuilder result = new StringBuilder();
        for (int[] row : findQuietestPaths()) {
            for (int cell : row) {
                result.append(cell).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }
    public String printNext(){
        StringBuilder result = new StringBuilder();
        for (int[] row : next) {
            for (int cell : row) {
                result.append(cell+1).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
