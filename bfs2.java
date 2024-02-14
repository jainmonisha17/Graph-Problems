import java.util.*;

public class bfs2 {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList) {

        // needed for BFS
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            Integer temp = queue.poll();
            bfs.add(temp);

            for(Integer currentNeighbour : adjList.get(temp)) {
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


// Time Complexity: O(N) + 2(E), where N = nodes, 2E is for total degrees as we traverse all adjacent nodes

// Space Complexity: O(3N) which is equal to O(N), O(3N) coz we are using 
// ArrayList<Integer> bfs = new ArrayList<>();  to return the answer bfs
// boolean visited[] = new boolean[V];  to see if the node has been visited or not with the size V
// Queue<Integer> queue = new LinkedList<>(); 
