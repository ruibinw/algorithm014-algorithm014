package friend_circles;

import union_find.UnionFind;

/**
 * dfs
 * Time: O(n)，n=学生的个数
 * Space: O(n)
 */
class Solution1 {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfsFindCircle(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfsFindCircle(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfsFindCircle(M, visited, j);
            }
        }
    }
}

/**
 * 并查集
 */
class Solution2 {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}
