import java.util.*;

public class bipartite1 {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adjList) {
        // needed
        int visited[] = new int[V];

        // Initialize the initial visited array with -1
        for(int i = 0; i < V; i++) {
            visited[i] = -1;
        }

        // for connected components
        for(int i = 0; i < V; i++) {
            if(visited[i] == -1) {
                if(dfs(i, 0, visited, adjList) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int current, int presentColor, int visited[], ArrayList<ArrayList<Integer>> adjList) {
        visited[current] = presentColor;

        // traverse the adj nodes
        for(int adjNode: adjList.get(current)) {
            if(visited[adjNode] == -1) {
                if(dfs(adjNode, 1 - presentColor, visited, adjList) == false) {
                    return false;
                }
            } else if(visited[adjNode] == presentColor) {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(1).add(3);
        adjList.get(3).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        bipartite1 obj = new bipartite1();
        boolean ans = obj.isBipartite(4, adjList);

        if(ans) {
            System.out.println("Its Bipartite");
        } else {
            System.out.println("Its not a Bipartite!");
        }
    }
}

// TC -> O(V + 2E), where v = vertices, 2E is for total degrees as we traverse all adjacent nodes
// SC -> O(3V) which is equals to O(V)
// Space for 1. DFS Stack
//           2. visited array
//           3. adjacency list
