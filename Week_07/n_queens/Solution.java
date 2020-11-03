package n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 回溯算法 + 哈希表记录位置
 * Time: O(n!)
 * Space: O(4n)
 */
class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solveNQueens(results, queens, n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return results;
    }

    private void solveNQueens(List<List<String>> results, int[] queens, int n, int row, HashSet<Integer> above, HashSet<Integer> diag1, HashSet<Integer> diag2) {
        if (row == n) {
            results.add(generateBoard(queens, n));
        } else {
            for (int col = 0; col < n; col++) {
                int d1 = row - col, d2 = row + col;
                if (!above.contains(col) && !diag1.contains(d1) && !diag2.contains(d2)) {
                    queens[row] = col;
                    above.add(col);
                    diag1.add(d1);
                    diag2.add(d2);
                    solveNQueens(results, queens, n, row + 1, above, diag1, diag2);
                    //backtrack to find other solutions
                    above.remove(col);
                    diag1.remove(d1);
                    diag2.remove(d2);
                }
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

/**
 * 回溯算法 + 循环判断有效性
 * Time: O(n!)
 * Space: O(n)
 */
class Solution2 {
    private int n;
    private int[] queens;
    private List<List<String>> results;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queens = new int[n];
        this.results = new ArrayList<>(n);
        placeNextQueen(0);
        return results;
    }

    private void placeNextQueen(int row) {
        if (row == n) {
            results.add(board());
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

    private List<String> board() {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

/**
 * 回溯算法 + 位运算
 */
class Solution3 {
    private int n;
    private int bits;
    private int[] queens;
    private List<List<String>> results;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.bits = ((1 << n) - 1);
        this.queens = new int[n];
        this.results = new ArrayList<>(n);
        placeNextQueen(0, 0, 0, 0);
        return results;
    }
    //columns, diag1, diag2 save the invalid loc to place the next Q (already covered by the prev Q)
    private void placeNextQueen(int row, int columns, int diag1, int diag2) {
        if (row == n) {
            results.add(board());
            return;
        }
        int availableLocations = bits & (~(columns | diag1 | diag2));//to get all loc to place Q
        while (availableLocations != 0) {
            int loc = availableLocations & (-availableLocations);//to get the first 1 (valid loc)
            int col = Integer.bitCount(loc - 1);//get the first 1 loc in form of array index for queens
            queens[row] = col;//place Q in array
            availableLocations = availableLocations & (availableLocations - 1);//remove the last 1 in binary = remove the avail loc that we just place Q
            placeNextQueen(row + 1, columns | loc, (diag1 | loc) << 1, (diag2 | loc) >> 1);//include the loc we just place Q in columns, diag1, diag2 using or |, and for diag we have to shift 1 loc to the left or right (topright diag or topleft respectively) to restrict the next Q
        }

    }

    private List<String> board() {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
