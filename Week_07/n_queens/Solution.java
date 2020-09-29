package n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 回溯算法
 */
class Solution {
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
