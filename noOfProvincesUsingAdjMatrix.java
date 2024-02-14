// Name: Monisha Jain
// Qualification: MCA
// College: PES University, Bengaluru

// Problem Statement: Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.


import java.util.ArrayList;

public class noOfProvincesUsingAdjMatrix {

    public void dfs(int[][] adjMatrix, int[] visited, int i) {
        for (int j = 0; j < adjMatrix.length; j++) {
            if (adjMatrix[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(adjMatrix, visited, j);
            }
        }
    }

    public static int numProvinces(int[][] adjMatrix) {
        int[] visited = new int[adjMatrix.length];
        int count = 0;

        for (int currentNode = 0; currentNode < adjMatrix.length; currentNode++) {
            if (visited[currentNode] == 0) {
                count++;
                visited[currentNode] = 1;
                new noOfProvincesUsingAdjMatrix().dfs(adjMatrix, visited, currentNode);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // adj matrix
        int[][] adjMatrix = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };

        System.out.println(noOfProvincesUsingAdjMatrix.numProvinces(adjMatrix));
    }
}
