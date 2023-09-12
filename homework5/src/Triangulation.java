public class Triangulation{
    private int numOfPoints;
    private float[][] point;
    private float[][] dp;
    public Triangulation(int numOfPoints, float[][] point){
        this.numOfPoints = numOfPoints;
        this.point = point;
        dp = new float[numOfPoints][numOfPoints];
    }
public float getMinCost(int i, int j){
    if(j-i < 2){
        return 0;
    }

    // If value already computed, return it
    if (dp[i][j] != 0) {
        return dp[i][j];
    }

    float min = Float.MAX_VALUE;
    for(int k = i+1; k < j; k++){
        float temp = getMinCost(i, k) + getMinCost(k, j) + perimeter(i, j, k);
        if(temp < min){
            min = temp;
        }
    }

    // Store the computed value in dp table
    dp[i][j] = min;

    return min;
}

    public float perimeter(int i, int j, int k){
        float ans = 0;
        ans += distance(i, j);
        ans += distance(j, k);
        ans += distance(k, i);
        return ans;
    }
    public float distance(int i, int j){
        float ans=0;
        ans = (point[i][0]-point[j][0])*(point[i][0]-point[j][0]) + (point[i][1]-point[j][1])*(point[i][1]-point[j][1]);
        ans = (float)Math.sqrt(ans);
        return ans;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Number of points : ").append(numOfPoints).append("\n");
        sb.append("Points : \n");
        for(int i = 0; i < numOfPoints; i++){
            sb.append("(").append(point[i][0]).append(",").append(point[i][1]).append(")\n");
        }
        sb.append("Minimum cost : ").append(getMinCost(0, numOfPoints-1)).append("\n");
        return sb.toString();
    }
    public String printDP(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numOfPoints; i++){
            for(int j = 0; j < numOfPoints; j++){
                sb.append(dp[i][j]).append(" \t\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}