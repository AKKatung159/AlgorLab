import java.util.Arrays;

public class Graph {
    private int[][] data;
    public int[] path;

    public Graph(int[][] data) {
        this.data = data;
        path = new int[data.length];
    }

    public String toString() {
        StringBuilder line = new StringBuilder();
        for (int[] ints : data) {
            for (int j = 0; j < data[0].length; j++) {
                line.append(ints[j]).append(" ");
            }
            line.append("\n");
        }
        return line.toString();
    }

    public int isStronglyConnected() {
        for (int i = 0; i < data.length; i++) {
            boolean[] visited = new boolean[data.length];
            int[] parent = new int[data.length];
            Arrays.fill(parent, -1);

            // Perform DFS starting from vertex i
            dfs(i, visited, parent);

            // Check if all vertices are visited
            for (boolean v : visited) {
                if (!v) {
                    return 0;
                }
            }
        }

        return 1;
    }

    private void dfs(int vertex, boolean[] visited, int[] parent) {
        visited[vertex] = true;
        for (int i = 0; i < data.length; i++) {
            if (data[vertex][i] == 1 && !visited[i]) {
                parent[i] = vertex;
                dfs(i, visited, parent);
            }
        }
    }
}
