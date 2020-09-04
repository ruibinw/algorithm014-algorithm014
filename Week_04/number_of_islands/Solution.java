package number_of_islands;

/**
 * DFS
 * 扫描整个数组，找到陆地（grid[i][j] == 1）时，
 * 等于找到一个岛屿 count + 1， 并把所有相邻的陆地打掉（数组里的所有相邻的 1 改成 0）
 * 继续扫描直到最后一个元素
 *
 */
class Solution1 {
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int islands = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    flood(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void flood(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;
        grid[i][j] = '0';
        flood(grid, i + 1, j);
        flood(grid, i - 1, j);
        flood(grid, i, j + 1);
        flood(grid, i, j - 1);
    }
}
