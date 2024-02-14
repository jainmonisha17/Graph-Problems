import java.util.*;

public class dfs1 {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList) {
        // needed
        boolean visited[] = new boolean[V];
        ArrayList<Integer> dfsAnswer = new ArrayList<>();

        visited[0] = true;
        dfs(0, visited, adjList, dfsAnswer);
        return dfsAnswer;
    }

    public void dfs(int currentNode, boolean visited[], ArrayList<ArrayList<Integer>> adjList,
            ArrayList<Integer> dfsAnswer) {
        // mark the current node as visited
        visited[currentNode] = true;
        dfsAnswer.add(currentNode);

        // getting the neighbour nodes
        for (Integer currentNeighbour : adjList.get(currentNode)) {
            if (visited[currentNeighbour] == false) {
                // visited[currentNeighbour] = true;
                dfs(currentNeighbour, visited, adjList, dfsAnswer);
            }
        }
    }

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adjList = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList < > ());
        }
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);
        
        dfs1 sl = new dfs1(); 
        ArrayList < Integer > ans = sl.dfsOfGraph(5, adjList);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }
}
