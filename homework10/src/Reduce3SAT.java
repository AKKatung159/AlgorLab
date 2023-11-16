public class Reduce3SAT {
    private int numClauses;
    private int numVariables;
    private int[][] clauses;
    public Reduce3SAT( int[][] clauses,int numVariables){
        this.clauses = clauses;
        this.numClauses = clauses.length;
        this.numVariables = numVariables;
    }
    public String toString(){
        String result = "";
        for(int i = 0 ; i < numClauses ; i++){
            for(int j = 0 ; j < clauses[i].length ; j++){
                result += clauses[i][j] + " ";
            }
            result += "\n";
        }
        // result+= "Number of variables: " + numVariables + "\n";
        // result+= "Number of clauses: " + numClauses + "\n";
        result+= "Number of vertices: " + (numVariables * 2 + numClauses * 3) + "\n";
        // result+= "Number of edges: " + (numVariables + numClauses * 3) + "\n";
        result+= "Number of vertex cover: " + (numVariables + numClauses * 2) + "\n";
        result+= "Adjacency Matrix: \n";
        int[][] adjMatrix = convertToAdjacencyMatrix();
        for(int i = 0 ; i < adjMatrix.length ; i++){
            for(int j = 0 ; j < adjMatrix[i].length ; j++){
                result += adjMatrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
    public int[][] convertToAdjacencyMatrix() {
        // For each variable and its negation, and 3 vertices per clause
        int size = numVariables * 2 + numClauses * 3;
        int[][] graph = new int[size][size];

        // Add edges for each variable and its negation
        for (int i = 0; i < numVariables; i++) {
            graph[i * 2][i * 2 + 1] = 1;
            graph[i * 2 + 1][i * 2] = 1;
        }

        // Offset to start of the clause gadgets in the graph
        int clauseOffset = numVariables * 2;
        for (int i = 0; i < numClauses; i++) {
            int[] clause = clauses[i];

            // Create a triangle for each clause
            for (int j = 0; j < clause.length; j++) {
                int vertexIdx = getVariableIndex(clause[j]);
                graph[vertexIdx][clauseOffset + i * 3 + j] = 1;
                graph[clauseOffset + i * 3 + j][vertexIdx] = 1;

                for (int k = 0; k < clause.length; k++) {
                    if (j != k) {
                        graph[clauseOffset + i * 3 + j][clauseOffset + i * 3 + k] = 1;
                        graph[clauseOffset + i * 3 + k][clauseOffset + i * 3 + j] = 1;
                    }
                }
            }
        }

        return graph;
    }

    private int getVariableIndex(int literal) {
        int variable = Math.abs(literal);
        int index = (variable - 1) * 2;
        if (literal < 0) {
            index += 1; // Index for the negation
        }
        return index;
    }

}