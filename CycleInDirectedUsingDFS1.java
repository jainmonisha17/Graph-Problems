import java.util.*;

public class CycleInDirectedUsingDFS1 {
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean visited[] = new boolean[V];
        boolean pathVisited[] = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(visited[0] == false) {
                if(dfs(i, adjList, visited, pathVisited) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int currentNode, ArrayList<ArrayList<Integer>> adjList, boolean visited[], boolean pathVisited[]) {
        visited[currentNode] = true;
        pathVisited[currentNode] = true;

        for(int adjNode: adjList.get(currentNode)) {
            if(visited[adjNode] == false) {
                if(dfs(adjNode, adjList, visited, pathVisited) == true) {
                    return true;
                }
            } else if(pathVisited[adjNode] == true) {
                return true;
            }
        }

        pathVisited[currentNode] = false;
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
