import java.util.*;

class CycleUndirectedUsingBFS {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList) {
        // needed
        boolean visited[] = new boolean[V];
        // intiate
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

    public boolean detectForCycle(int current, int V, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[current] = true;
        // needed
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(current, -1));

        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();

            for (int adjNode : adjList.get(node)) {
                if (visited[adjNode] == false) {
                    visited[adjNode] = true;
                    queue.add(new Pair(adjNode, node));
                } else if (parent != adjNode) { // (6, 3) (node, parent) adjNode = 7
                    return true; // 7 is not visited from parent 3 but it is visited from some other person that
                                 // is from 2 as a parent frm 5
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

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}