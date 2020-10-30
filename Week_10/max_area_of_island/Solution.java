package max_area_of_island;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = dfsCountConnectedLand(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfsCountConnectedLand(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = -1;
        return 1 + dfsCountConnectedLand(grid, i - 1, j)
                 + dfsCountConnectedLand(grid, i + 1, j)
                 + dfsCountConnectedLand(grid, i, j - 1)
                 + dfsCountConnectedLand(grid, i, j + 1);
    }
}
