public class noOfProvincesUsingAdjMatrix1 {

    public int findProvinces(int[][] adjMatrix) {
        // needed
        int n = adjMatrix.length;
        int[] visited = new int[n];
        int count = 0;

        for(int currentNode = 0; currentNode < n; currentNode++) {
            if(visited[currentNode] == 0) {
                dfs(adjMatrix, visited, currentNode);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] adjMatrix, int[] visited, int currentNode) {
        int n = adjMatrix.length;
        
        for(int currentNodeNeighbour = 0;  currentNodeNeighbour < n; currentNodeNeighbour++) {
            if(adjMatrix[currentNode][currentNodeNeighbour] == 1 && visited[currentNodeNeighbour] == 0) {
                visited[currentNodeNeighbour] = 1;
                dfs(adjMatrix, visited, currentNodeNeighbour);
            }
        }
    }
    
    public static void main(String[] args) {
        // adj matrix
        int[][] adjMatrix = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };

        System.out.println(noOfProvincesUsingAdjMatrix.numProvinces(adjMatrix));
    }
}
