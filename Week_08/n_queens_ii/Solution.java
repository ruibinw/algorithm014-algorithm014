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
        size = (1 << n) - 1; //二进制 n个 1 （如，n=4， size = 1111）
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}
