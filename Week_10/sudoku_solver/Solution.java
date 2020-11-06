package sudoku_solver;

class Solution {
    boolean[][] existInRow = new boolean[9][10];
    boolean[][] existInCol = new boolean[9][10];
    boolean[][][] existInBox = new boolean[3][3][10];
    boolean isSolved = false;

    public void solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int num = board[row][col] - '0';
                    setExistState(row, col, num, true);
                }
            }
        }
        solve(board, 0, 0);
    }

    private void solve(char[][] board, int row, int col) {
        if (col == 9) {
            col = 0;
            if (++row == 9) {
                isSolved = true;
                return;
            }
        }

        if (board[row][col] == '.') {
            for (int num = 1; num < 10; num++) {
                if (isNumExisted(row, col, num)) continue;

                board[row][col] = (char) ('0' + num);
                setExistState(row, col, num, true);

                solve(board, row, col + 1);
                if (isSolved) return;

                board[row][col] = '.';
                setExistState(row, col, num, false);
            }
        } else {
            solve(board, row, col + 1);
        }
    }

    private void setExistState(int row, int col, int num, boolean state) {
        existInRow[row][num] = state;
        existInCol[col][num] = state;
        existInBox[row / 3][col / 3][num] = state;
    }

    private boolean isNumExisted(int row, int col, int num) {
        return existInRow[row][num] || existInCol[col][num] || existInBox[row / 3][col / 3][num];
    }
}
