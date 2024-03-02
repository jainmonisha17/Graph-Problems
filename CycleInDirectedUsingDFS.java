import java.util.*;

public class CycleInDirectedUsingDFS {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        int visited[] = new int[V];
        int pathVisited[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adjList, visited, pathVisited) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int current, ArrayList<ArrayList<Integer>> adjList, int visited[], int pathVisited[]) {
        visited[current] = 1;
        pathVisited[current] = 1;

        // traverse for the adj nodes
        for (int adjNode : adjList.get(current)) {
            // when the adjNode is not visited
            if (visited[adjNode] == 0) {
                if (dfs(adjNode, adjList, visited, pathVisited) == true) {
                    return true;
                }
            } else if(pathVisited[adjNode] == 1) {                   // but it has to be visited on the same path
                    return true;
                
            }
        }
        pathVisited[current] = 0;
        return false;
    }

    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++) {
             adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(3).add(7);
        adjList.get(4).add(5);
        adjList.get(5).add(6);
        adjList.get(7).add(5);
        adjList.get(8).add(9);
        adjList.get(9).add(10);
        adjList.get(10).add(8);

        CycleInDirectedUsingDFS obj = new CycleInDirectedUsingDFS();
        boolean ans = obj.isCycle(V, adjList);

        if(ans) { // false no cycle
             System.out.println("True. Cycle exist");
        } else {
            System.out.println("False. Cycle does'nt exist");
        }
    }
}


