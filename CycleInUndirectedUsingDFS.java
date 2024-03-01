import java.util.*;

public class CycleInUndirectedUsingDFS {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (dfs(i, -1, adjList, visited, V) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int current, int parent, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int V) {
        visited[current] = true;

        for (int adjNode : adjList.get(current)) {
            if (visited[adjNode] == false) {
                if (dfs(adjNode, current, adjList, visited, V) == true) {
                    return true;
                }
            } else if(adjNode != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(3).add(2);

        CycleInUndirectedUsingDFS obj = new CycleInUndirectedUsingDFS();
        boolean ans = obj.isCycle(4, adjList);
        if (ans)
            System.out.println("Cycle is there");
        else
            System.out.println("Cycle is not there");
    }
}
