
public class Graph {
    private int[][] adjacencyMatrix;
    private int[] cyclePath;

    public Graph(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.cyclePath = new int[adjacencyMatrix.length];
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : adjacencyMatrix) {
            for (int cell : row) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public int isStronglyConnected() {
        if (!isAllVerticesVisited())
            return 0;
        
        transposeMatrix();
        if (!isAllVerticesVisited())
            return 0;

        return 1;
    }

    private boolean isAllVerticesVisited() {
        boolean[] visited = new boolean[adjacencyMatrix.length];
        dfs(0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    
    private String printCyclePath() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cyclePath.length; i++) {
            sb.append(i+1).append(" -> ").append(cyclePath[i]+1).append("\n");
        }
        return sb.toString();
    }

    private void transposeMatrix() {
        int[][] transposed = new int[adjacencyMatrix.length][adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length ; j++) {
                transposed[i][j] = adjacencyMatrix[j][i];
            }
        }
        adjacencyMatrix = transposed;
    }

    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                cyclePath[i] = vertex;
                dfs(i, visited);
            }
        }
    }

    /**
     * Find a cycle path in the graph starting from vertex 0.
     * @return a string representation of the cycle path.
     */
    public String findCyclePath() {
        boolean[] visited = new boolean[adjacencyMatrix.length];
        dfs(0, visited);
        return printCyclePath();
    }
}
