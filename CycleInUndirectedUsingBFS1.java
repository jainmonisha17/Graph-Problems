import java.util.*;

public class CycleInUndirectedUsingBFS1 {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        // needed
        boolean visited[] = new boolean[V];
        // intialize the visited array with 0 or false
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (detectForCycle(i, V, adjList, visited) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectForCycle(int current, int V, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[current] = true;
        // needed
        Queue<Pairrr> queue = new LinkedList<>();
        queue.add(new Pairrr(current, -1));
        queue.remove();

        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            for (int adjNode : adjList.get(node)) {
                if (visited[node] == false) {
                    visited[node] = true;
                    queue.add(new Pairrr(adjNode, parent));
                } else if (parent != adjNode) {
                    return true;
                }
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
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        CycleUndirectedUsingBFS obj = new CycleUndirectedUsingBFS();
        boolean ans = obj.isCycle(4, adjList);
        if (ans)
            System.out.println("Cycle is there");
        else
            System.out.println("Cycle is not there");
    }
}

class Pairrr {
    int first;
    int second;

    public Pairrr(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
