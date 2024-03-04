import java.util.*;

public class rottenOranges1 {

    public static int orangesRotten(int[][] grid) {
        // test cases
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        // needed
        Queue<myPair> queue = new LinkedList<>();
        int visited[][] = new int[n][m];
        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new myPair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        if (countFresh == 0) {
            return 0; // when there are no fresh oranges to rot then no use of traversing the entire
                      // graph just return 0 at first
        }

        int tm = 0;
        int timeCount = 0;
        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, 0, -1 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().tm;

            tm = Math.max(time, tm);
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int neighbourRow = row + delRow[i];
                int neighbourCol = col + delCol[i];
                if (neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m && visited[neighbourRow][neighbourCol] == 0 && grid[neighbourRow][neighbourCol] == 1) {
                    queue.add(new myPair(neighbourRow, neighbourCol, time + 1));
                    visited[neighbourRow][neighbourCol] = 2;
                    timeCount++;
                }

            }
        }

        if(timeCount != countFresh) {
            return -1;
        }
        return tm;
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 }
        };
        int ans = orangesRotten(grid);
        System.out.println("Minimun number of minutes required: " + ans);
    }
}

class myPair {
    int row;
    int col;
    int tm;

    // constructor
    myPair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
