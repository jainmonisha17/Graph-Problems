import java.util.*;

public class floodFill1 {

    public void dfs(int[][] image, int row, int col, int newColor, int initialColor, int[][] ans, int delRow[], int delCol[]) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        // there are exactly 4 neighbours
        for(int i = 0; i < 4; i++) {
            int neighbourRow = row + delRow[i];
            int neighbourCol = col + delCol[i];

            // check for valid coordinates
            // then check for same initial color and unvisited pixel
            if(neighbourRow >= 0 && neighbourRow < n && 
               neighbourCol >= 0 && neighbourCol < m && 
               image[neighbourRow][neighbourCol] == initialColor && ans[neighbourRow][neighbourCol] != newColor) {
                ans[neighbourRow][neighbourCol] = newColor;
                dfs(image, neighbourRow, neighbourCol, newColor, initialColor, ans, delRow, delCol);
               }
        }
    }

    public int[][] floodFillFunction(int[][] image, int sr, int sc, int newColor) {
        // get the initial color
        int initialColor = image[sr][sc];
        // needed
        int[][] ans = image; // copying the original data to another integer arr called ans to not alter the
                             // original data

        // delta row and delta col for neighbours
        int delRow[] = { -1, 0, +1, 0 };
        int delCol[] = { 0, +1, 0, -1 };
        dfs(image, sr, sc, newColor, initialColor, ans, delRow, delCol);

        return ans;
    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        // sr = 1, sc = 1, newColor = 2
        floodFill1 obj = new floodFill1();
        int[][] ans = obj.floodFillFunction(image, 1, 1, 2);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " "); // we are returning the matrix at last so 2 for loops for 2d matrix
            }
            System.out.println();
        }
    }
}
