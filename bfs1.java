import java.util.*;

public class bfs1 {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList) {

        // needed for BFS
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[V];  // contains only 0's and 1's
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0); // adding first node
        visited[0] = true;  // marking visted as true

        while(!queue.isEmpty()) {
            Integer temp = queue.poll();
            bfs.add(temp);

            // get alll the adjacent vertices of the dequed vertes s
            // if a adjacent has not been visited, then mark it
            // visited and enqueue it

            for(Integer currentNeighbour: adjList.get(temp)) {
                if(visited[currentNeighbour] == false) {
                    visited[currentNeighbour] = true;
                    queue.add(currentNeighbour);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(4);
        adjList.get(4).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(1).add(3);
        adjList.get(3).add(1);

        bfs1 obj = new bfs1();
        ArrayList<Integer> bfs = obj.bfsOfGraph(5, adjList);
        int n = bfs.size();

        for(int i = 0; i < n; i++) {
            System.out.print(bfs.get(i) + "  ");
        }

    }
}
