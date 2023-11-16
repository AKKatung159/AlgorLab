import java.util.ArrayList;
import java.util.List;

public class GraphVertexCoverApp {
    private int[][] adjMatrix;
    private int n;

    public GraphVertexCoverApp(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
        this.n = adjMatrix.length;
    }
    public String toString(){
        String result = "";
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                result += adjMatrix[i][j] + " ";
            }
            result += "\n";
        }
        result+= "Approximate Vertex Cover: ";
        result+= getApproximateVertexCover();
        result += "\nNumber of vertex: " + getApproximateVertexCover().size();

        return result;
    }
    public List<Integer> getApproximateVertexCover() {
        List<Integer> vertexCover = new ArrayList<>();
        boolean[] isCovered = new boolean[n]; // Initially, no vertex is covered

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == 1 && !isCovered[i] && !isCovered[j]) {
                    // If there's an edge between i and j, and neither is covered
                    vertexCover.add(i+1); // Add both i and j to the vertex cover
                    vertexCover.add(j+1);
                    isCovered[i] = true; // Mark both vertices as covered
                    isCovered[j] = true;
                }
            }
        }

        return vertexCover;
    }
    
}