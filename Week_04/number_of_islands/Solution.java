package number_of_islands;

/**
 * DFS
 * 扫描整个数组，找到陆地（grid[i][j] == 1）时，
 * 等于找到一个岛屿 count + 1， 并把所有相邻的陆地打掉（数组里的所有相邻的 1 改成 0）
 * 继续扫描直到最后一个元素
 */
class Solution1 {
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;

        m = grid[0].length;

        int islands = 0;
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

/**
 * 并查集
 */
class Solution2 {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;

        int cols = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}};

        UnionFind uf = new UnionFind(rows * cols);
        int water = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x < rows && y < cols && grid[x][y] == '1')
                            uf.union(cols * i + j, cols * x + y);
                    }
                } else {
                    water++;
                }
            }
        }
        return uf.count - water;
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootQ] = rootP;
            count--;
        }

        int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}
