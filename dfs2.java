import java.util.*;

public class dfs2 {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adjList) {
        // needed
        ArrayList<Integer> dfsAnswer = new ArrayList<>();
        boolean visited[] = new boolean[V];
        dfs(0, visited, adjList, dfsAnswer);
        visited[0] = true;
        return dfsAnswer;
    }

    public void dfs(int currentNode, boolean visited[], ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfsAnswer) {
        visited[currentNode] = true;
        dfsAnswer.add(currentNode);
        
        // explore
        for(int currentNodeNeighbour : adjList.get(currentNode)) {
            if(visited[currentNodeNeighbour] == false) {
                dfs(currentNodeNeighbour, visited, adjList, dfsAnswer);
            }
        }
    }
    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);

        dfs2 sl = new dfs2();
        ArrayList<Integer> ans = sl.dfsOfGraph(5, adjList);
        
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
