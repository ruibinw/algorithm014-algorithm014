package surrounded_regions;

/**
 * DFS
 * 1. 先DFS标记所有边界上的 O （改成 #）
 * 2. 再遍历把所有剩下的 O 改成 X
 * 3. 同时把 # 改回来（改成 O）
 */
class Solution1 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isBorder = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isBorder && board[i][j] == 'O') {
                    dfsMarkBorder(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    public void dfsMarkBorder(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#')
            return;
        board[i][j] = '#';
        dfsMarkBorder(board, i - 1, j);
        dfsMarkBorder(board, i + 1, j);
        dfsMarkBorder(board, i, j - 1);
        dfsMarkBorder(board, i, j + 1);
    }
}

/**
 * 并查集
 * 1.创建并查集时，特意多留一个节点作为边界节点，用来关联所有边界的 O
 * 2.把连续的 O 都关联起来
 * 3.把所有非边界的 O 改成 X
 */
class Solution2 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {{1, 0}, {0, 1}};
        UnionFind uf = new UnionFind(m * n + 1);
        int borderNode = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    uf.union(borderNode, n * i + j);
                }
                if (board[i][j] == 'O') {
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && y >= 0 && x < m && y < n && board[x][y] == 'O')
                            uf.union(n * i + j, n * x + y);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.isConnected(borderNode, n * i + j))
                    board[i][j] = 'X';
            }
        }
    }

    class UnionFind {
        int count;
        int[] parent;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootQ] = rootP;
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
