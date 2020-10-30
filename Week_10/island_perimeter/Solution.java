package island_perimeter;

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;

        int n = grid.length, m = grid[0].length;
        int count = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || y < 0 || x == n || y == m || grid[x][y] == 0)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
