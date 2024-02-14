// Name: Monisha Jain
// Qualification: MCA
// College: PES University, Bengaluru

// Problem Statement: Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.


import java.util.*;

public class noOfProvinces {

    private static void dfs(int currentNode, ArrayList<ArrayList<Integer>> adjList, int visited[]) {
        visited[currentNode] = 1;

        ArrayList<Integer> neighbours = adjList.get(currentNode);
        int neighboursSize = neighbours.size();

        for (int i = 0; i < neighboursSize; i++) {
            Integer it = neighbours.get(i);
            if (visited[it] == 0) {
                dfs(it, adjList, visited);
            }
        }
    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adjMatrix, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        // initialize adjList with new arrayList
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // to change adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // self nodes are not considered

                if (adjMatrix.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int visited[] = new int[V];
        int count = 0;

        for (int currentNode = 0; currentNode < V; currentNode++) {
            if (visited[currentNode] == 0) {
                count++;
                dfs(currentNode, adjList, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // adj matrix

        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<ArrayList<Integer>>();
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(0).add(0, 1);
        adjMatrix.get(0).add(1, 0);
        adjMatrix.get(0).add(2, 1);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(1).add(0, 0);
        adjMatrix.get(1).add(1, 1);
        adjMatrix.get(1).add(2, 0);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(2).add(0, 1);
        adjMatrix.get(2).add(1, 0);
        adjMatrix.get(2).add(2, 1);

        // noOfProvinces object = new noOfProvinces();
        System.out.println(noOfProvinces.numProvinces(adjMatrix, 3));
    }
}

// Time Complexity:

// O(N) + O(V + 2E), where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph
// to change adj matrix to adjList
// and we know DFS takes time of O(V + 2E)

// Space complexity:
// O(N) + O(N), for recurison stack space(coz we have used DFS) and visited array
