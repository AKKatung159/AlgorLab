import java.util.ArrayList;
import java.util.List;

public class Graph2 {
    private int[][] data;
    public int[] path;
    public boolean[] visit;

    public Graph2(int[][] data) {
        this.data = data;
        path = new int[data.length];
        visit = new boolean[data.length];
    }

    public boolean isHamiltonian() {
        // Reset path and visit arrays for a fresh search
        path = new int[data.length];
        visit = new boolean[data.length];

        // starting the path from the 0-th vertex
        path[0] = 0;
        // if there's a Hamiltonian path, it will set appropriate values in 'path'
        if (!findHamiltonian(1)) {
            return false;
        }
        displayCycle();
        return true;
    }

    private boolean findHamiltonian(int pos) {
        if (pos == data.length) {
            // check if last vertex connects to the starting vertex
            return data[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < data.length; v++) {
            if (isValid(v, pos)) {
                path[pos] = v;
                if (findHamiltonian(pos + 1)) {
                    return true;
                }
                path[pos] = -1; // backtrack
            }
        }
        return false;
    }

    private boolean isValid(int v, int pos) {
        return data[path[pos - 1]][v] != 0 && !contains(path, v, pos);
    }

    private boolean contains(int[] array, int v, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == v) {
                return true;
            }
        }
        return false;
    }

    public void displayCycle() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);
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

    public List<int[]> edgesToAddForHamiltonian() {
        List<int[]> edgesToAdd = new ArrayList<>();

        if (isHamiltonian()) {
            return edgesToAdd;
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i][j] == 0) {
                    // Add an edge
                    data[i][j] = 1;
                    data[j][i] = 1;

                    if (isHamiltonian()) {
                        edgesToAdd.add(new int[]{i, j});
                    }

                    // Remove the added edge for the next iteration
                    data[i][j] = 0;
                    data[j][i] = 0;
                }
            }
        }

        return edgesToAdd;
    }
}
