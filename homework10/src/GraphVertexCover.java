import java.util.ArrayList;
import java.util.List;

public class GraphVertexCover {
    private int[][] adjMatrix;
    private int k;
    private int n;
    public GraphVertexCover(int k , int[][] adjMatrix){
        this.k = k;
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
        result+= "All Coverings: ";
        result+= getAllCoverings();
        return result;
    }
    public List<List<Integer>> getAllCoverings() {
        List<List<Integer>> allCoverings = new ArrayList<>();
        // Using a bit mask to generate all subsets of vertices
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> vertexCover = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) { // If the j-th vertex is in the subset
                    vertexCover.add(j);
                }
            }
            if (isVertexCover(vertexCover)) {
                if (vertexCover.size() == k) {
                    for (int i = 0; i < vertexCover.size(); i++) {
                        vertexCover.set(i, vertexCover.get(i) + 1);
                    }
                    allCoverings.add(vertexCover);
                }
            }
        }
        allCoverings.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) < b.get(i)) {
                    return -1;
                } else if (a.get(i) > b.get(i)) {
                    return 1;
                }
            }
            return 0;
        }
        );
        return allCoverings;
    }

    private boolean isVertexCover(List<Integer> vertexCover) {
        // Create a copy of the adjacency matrix
        int[][] tempMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(adjMatrix[i], 0, tempMatrix[i], 0, adjMatrix[i].length);
        }

        // Remove all edges adjacent to the vertices in the vertex cover
        for (int vertex : vertexCover) {
            for (int i = 0; i < n; i++) {
                tempMatrix[vertex][i] = 0;
                tempMatrix[i][vertex] = 0;
            }
        }

        // Check if all edges are covered
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tempMatrix[i][j] == 1) { // If there's an edge not covered
                    return false;
                }
            }
        }
        return true;
    }
}
