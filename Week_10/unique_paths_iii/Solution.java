package unique_paths_iii;

/**
 * DFS 回溯
 */
class Solution {
    int path = 0, empty = 1;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length, sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return path;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) return;
        if (grid[x][y] == 2) {
            if (empty == 0) path++;
            return;
        }
        grid[x][y] = -2;
        empty--;
        for (int[] d : dirs) {
            dfs(grid, x + d[0], y + d[1]);
        }
        grid[x][y] = 0;
        empty++;
    }
}
