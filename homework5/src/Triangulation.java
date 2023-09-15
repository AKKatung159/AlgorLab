import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Triangulation {
    private int numOfPoints;
    private float[][] point;
    private float[][] dp;
    private int[][] jTable;

    public Triangulation(int numOfPoints, float[][] point) {
        this.numOfPoints = numOfPoints;
        this.point = point;
        dp = new float[numOfPoints][numOfPoints];
        jTable = new int[numOfPoints][numOfPoints];
        for (int i = 0; i < jTable.length; i++) {
            for (int j = 0; j < jTable.length; j++)
                jTable[i][j] = -1;
        }
    }

    public float getMinCost(int i, int j) {
        if (j - i < 2) {
            return 0;
        }

        // If value already computed, return it
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        float min = Float.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            float temp = getMinCost(i, k) + getMinCost(k, j) + perimeter(i, j, k);
            if (temp < min) {
                min = temp;
                jTable[i][j] = k;
            }
        }

        // Store the computed value in dp table
        dp[i][j] = min;

        return min;
    }

    public float perimeter(int i, int j, int k) {
        float ans = 0;
        ans += distance(i, j);
        ans += distance(j, k);
        ans += distance(k, i);
        return ans;
    }

    public float distance(int i, int j) {
        float ans = 0;
        ans = (point[i][0] - point[j][0]) * (point[i][0] - point[j][0])
                + (point[i][1] - point[j][1]) * (point[i][1] - point[j][1]);
        ans = (float) Math.sqrt(ans);
        return ans;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GrahamScan();
        sb.append("Number of points : ").append(numOfPoints).append("\n");
        sb.append("Points : \n");
        for (int i = 0; i < numOfPoints; i++) {
            sb.append("(").append(point[i][0]).append(",").append(point[i][1]).append(")\n");
        }
        sb.append("Minimum cost : ").append(getMinCost(0, numOfPoints - 1)).append("\n");
        sb.append("DP table : \n");
        sb.append(printDP());
        sb.append("J table : \n");
        sb.append(printJString());
        sb.append("Cut : \n");
        sb.append(printCut());
        return sb.toString();
    }

    public String printDP() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfPoints; i++) {
            for (int j = 0; j < numOfPoints; j++) {
                sb.append(dp[i][j]).append(" \t\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String printCut() {
        StringBuilder sb = new StringBuilder();
        sb.append(giveCut(0, numOfPoints - 1));
        return sb.toString();
    }

    private String giveCut(int i, int j) {
        if (j - i < 2) {
            return "";
        }
        int k = jTable[i][j];
        String leftCut = giveCut(i, k);
        String rightCut = giveCut(k, j);
        return leftCut + rightCut + "(" + i + ", " + j + ", " + k + ")\n";
    }

    public void GrahamScan() {
        Arrays.sort(point, new Comparator<float[]>() {
            public int compare(float[] o1, float[] o2) {
                double angle1 = Math.atan2(o1[1] - point[0][1], o1[0] - point[0][0]);
                double angle2 = Math.atan2(o2[1] - point[0][1], o2[0] - point[0][0]);
                return Double.compare(angle1, angle2);
            }
        });

        for (int i = 1; i < point.length; i++) {
            while (i > 1 && isCounterClockwise(point[i - 1], point[0], point[i])) {
                swap(point, i - 1, i);
                i--;
            }
        }
    }

    public static boolean isCounterClockwise(float[] p1, float[] p2, float[] p3) {
        float[] v1 = new float[] { p2[0] - p1[0], p2[1] - p1[1] };
        float[] v2 = new float[] { p3[0] - p1[0], p3[1] - p1[1] };
        float crossProduct = v1[0] * v2[1] - v1[1] * v2[0];
        return crossProduct > 0;
    }

    public static void swap(float[][] points, int i, int j) {
        float[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public String printJString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfPoints; i++) {
            for (int j = 0; j < numOfPoints; j++) {
                sb.append(jTable[i][j]).append(" \t\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}