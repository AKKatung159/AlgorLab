import java.util.Arrays;
import java.util.Stack;

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
    // public int howManyComponents() {
    //     int count =0;
    //     for (int i = 0; i < adjacencyMatrix.length; i++) {
    //         if(isAllVerticesVisited(i)){
    //             transposeMatrix();
    //              if(isAllVerticesVisited(i)){
    //             count++;
    //         }
    //         }
            
    //     }

    //     return count;
    // }

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
    // private boolean isAllVerticesVisited(int i) {
    //     boolean[] visited = new boolean[adjacencyMatrix.length];
    //     dfs(i, visited);
    //     for (boolean v : visited) {
    //         if (!v) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    
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
    public int howManyComponents() {
    int componentCount = 0;
    boolean[] visited = new boolean[adjacencyMatrix.length];
    Stack<Integer> stack = new Stack<>();
    
    // First DFS to fill the stack
    for (int i = 0; i < adjacencyMatrix.length; i++) {
        if (!visited[i]) {
            dfsForStack(i, visited, stack);
        }
    }

    // Reset visited array for second DFS
    Arrays.fill(visited, false);
    
    // Transpose the graph
    transposeMatrix();

    // Second DFS on transposed graph
    while (!stack.isEmpty()) {
        int vertex = stack.pop();
        if (!visited[vertex]) {
            dfs(vertex, visited); // You might need another dfs method if cyclePath is not needed.
            componentCount++;
        }
    }
    
    return componentCount;
}

private void dfsForStack(int vertex, boolean[] visited, Stack<Integer> stack) {
    visited[vertex] = true;
    for (int i = 0; i < adjacencyMatrix.length; i++) {
        if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
            dfsForStack(i, visited, stack);
        }
    }
    stack.push(vertex);
}


}
