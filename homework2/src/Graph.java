
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private int[][] graph;
    public List<List<Integer>> path;
    public List<List<Integer>> allPath;

    //กำหนดค่าให้ graph และ รีเซ็ตค่าเป็น 0
    public Graph(int[][] graph) {
        this.graph = graph;
        this.path = new ArrayList<>();
        this.allPath = new ArrayList<>();
    }

    public void findPath(int u, int v, boolean[] isVisit, List<Integer> path) {
        isVisit[u] = true;
        path.add(u);
        int h = 0;
        if (u == v) {
            addAllPath(path);
        } else {
            for (int i = 0; i < graph[u].length; i++) {
                int x = graph[u][i];
                if (x != 0 && !isVisit[i]) {
                    while (x > 0) {
                        findPath(i, v, isVisit, path);
                        x -= 1;
                    }
                }
            }
        }
        path.remove(path.size() - 1);
        isVisit[u] = false;
    }
    //แสดง graph
    public void printGraph() {
        for (int[] i : graph) {
            System.out.println(Arrays.toString(i));
        }
    }
    //สร้าง path จากจุด u ไป v
    public List<List<Integer>> getPath(int u, int v) {
        this.allPath = new ArrayList<>();
        boolean[] visit = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        findPath(u, v, visit, path);
        return this.allPath;
    }

    public void printAllPaths() {
        if (!allPath.isEmpty()) {
            System.out.printf("All paths from %d to %d%n", allPath.get(0).get(0),
                    allPath.get(0).get(allPath.get(0).size() - 1));
            for (List<Integer> path : allPath) {
                System.out.println(path);
            }
        }
    }

    private void addAllPath(List<Integer> path) {
        allPath.add(new ArrayList<>(path));
    }

    public void givenHamilCheck(int u, int v) {
        getPath(u, v);
        int c = 0;
        for (List<Integer> path : allPath) {
            if (path.size() == graph.length) {
                if (graph[v][u] != 0) {
                    System.out.println("Have Hamiltonian cycle: " + path);
                } else {
                    System.out.println("Have Hamiltonian path: " + path);
                    c = 1;
                }
            }
        }
        if (c == 0) {
            System.out.println("Not have Hamiltonian path/cycle");
        }
    }

    public int hamilCheck() {
        int c = 0;
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph.length; v++) {
                allPath.addAll(getPath(u, v));
                path.addAll(allPath); // Assuming deep copy here, as was done in Python
                for (List<Integer> path : allPath) {
                    if (path.size() == graph.length) {
                        if (graph[v][u] != 0) {
                            System.out.println("Have Hamiltonian cycle: " + path);
                        } else {
                            System.out.println("Have Hamiltonian path: " + path);
                        }
                        c++;
                    }
                }
            }
        }
        if (c == 0) {
            System.out.println("Not have Hamiltonian path/cycle");
            findAndCompleteCycle();
        }
        return c;
    }

    public void findAndCompleteCycle() {
        int maxLen = 0;
        List<Integer> big = null;
        List<List<Integer>> pathList = new ArrayList<>();
        for (List<Integer> p : path) {
            if (maxLen < p.size()) {
                big = p;
                maxLen = p.size();
            }
        }
        pathList.add(big);
        for (List<Integer> p : path) {
            List<Integer> a = new ArrayList<>(big);
            a.addAll(p);
            if (containsAllIntegersOnce(a, graph.length)) {
                pathList.add(p);
                break;
            }
        }

        System.out.println(pathList);
        System.out.println("Have to connect:");
        for (int i = 0; i < pathList.size() - 1; i++) {
            System.out.println(pathList.get(i).get(pathList.get(i).size() - 1) + " " + pathList.get(i + 1).get(0));
        }
        System.out.println(pathList.get(0).get(0) + " "
                + pathList.get(pathList.size() - 1).get(pathList.get(pathList.size() - 1).size() - 1));
        System.out.println("to have Hamiltonian cycle.");
    }

    private boolean containsAllIntegersOnce(List<Integer> array, int v) {
        Set<Integer> set = new HashSet<>(array);
        for (int i = 0; i < v; i++) {
            if (!set.remove(i)) {
                return false;
            }
        }
        return set.isEmpty();
    }

    public void displayCycle() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println(path.get(0));
    }

    public String toString() {
        StringBuilder line = new StringBuilder();
        for (int[] ints : graph) {
            for (int j = 0; j < graph[0].length; j++) {
                line.append(ints[j]).append(" ");
            }
            line.append("\n");
        }
        return line.toString();
    }

}
