import java.util.*;

public class distanceOfNearestCellHaving1 {

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;        

        // needed
        int visited[][] = new int[n][m];
        int distMatrix[][] = new int[n][m];
        Queue<myPairm> queue = new LinkedList<>();

        // traverse the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // start BFS if grid contains 1
                if (grid[i][j] == 1) {
                    queue.add(new myPairm(i, j, 0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0; // marks as unvisited
                }
            }
        }
        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, 0, -1 };

        // n * m * 4
        // traverse till queue becomes empty
        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int dist = queue.peek().third;
            queue.remove();
            distMatrix[row][col] = dist;

            // for all 4 neighbours
            for (int i = 0; i < 4; i++) {
                int neighbourRow = row + delRow[i];
                int neighbourCol = col + delCol[i];
                // check for valid unvisited cell

                if (neighbourRow >= 0 && neighbourRow < n &&
                    neighbourCol >= 0 && neighbourCol < m &&
                    visited[neighbourRow][neighbourCol] == 0) {
                        visited[neighbourRow][neighbourCol] = 1;
                        queue.add(new myPairm(neighbourRow, neighbourCol, dist + 1));
                }
            }
        }
        return distMatrix;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 1, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 }
        };

        distanceOfNearestCellHaving1 obj = new distanceOfNearestCellHaving1();
        int[][] ans = obj.nearest(grid);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) { // not ans[0] but it should be ans[i] coz it is not printing only
                                                      // first col but it is printing whole matrix
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class myPairm {
    int first;
    int second;
    int third;

    myPairm(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}


Time Complexity: O(NxM + NxMx4) ~ O(N x M)

For the worst case, the BFS function will be called for (N x M) nodes, and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.

Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)

O(N x M) for the visited array, distance matrix, and queue space takes up N x M locations at max. 
