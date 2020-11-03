package n_queens_ii;

/**
 * 回溯算法
 * Time: O(n!)
 * Space: O(n)
 */
class Solution1 {
    private int n;
    private int[] queens;
    private int count;

    public int totalNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        placeNextQueen(0);
        return count;
    }

    private void placeNextQueen(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (valid(row, col)) {
                queens[row] = col;
                placeNextQueen(row + 1);
            }
        }
    }

    private boolean valid(int row, int col) {
        int topLeft = col - 1, topRight = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (queens[i] == col || queens[i] == topLeft-- || queens[i] == topRight++)
                return false;
        }
        return true;
    }
}

/**
 * 位运算
 */
class Solution2 {
    private int count;
    private int size;

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1; //生成二进制的 n 个 1 (能放皇后的所有位置)
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int locs = size & (~(row | ld | rd));//取出有效位置（有效位置 = 在当前行能放置皇后的位置）
        while (locs != 0) {
            int cur = locs & (-locs);//取出最右边的有效位置
            solve(row | cur, (ld | cur) << 1, (rd | cur) >> 1);//更新被占用的位置，继续尝试下一行
            locs -= cur;//去掉最右边的有效位置，继续尝试放置下一个有效位置
        }
    }
}
