package sudoku_solver;

class Solution {
    boolean[][] existInRow = new boolean[9][10];
    boolean[][] existInCol = new boolean[9][10];
    boolean[][][] existInBox = new boolean[3][3][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    existInRow[i][num] = true;
                    existInCol[j][num] = true;
                    existInBox[i / 3][j / 3][num] = true;
                }
            }
        }
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) return true;
        }

        if (board[row][col] == '.') {
            for (int num = 1; num < 10; num++) {
                if (existInRow[row][num] || existInCol[col][num] || existInBox[row / 3][col / 3][num])
                    continue;

                board[row][col] = (char) ('0' + num);
                existInRow[row][num] = true;
                existInCol[col][num] = true;
                existInBox[row / 3][col / 3][num] = true;

                if (solve(board, row, col + 1)) return true;

                board[row][col] = '.';
                existInRow[row][num] = false;
                existInCol[col][num] = false;
                existInBox[row / 3][col / 3][num] = false;
            }
        } else {
            return solve(board, row, col + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }
}
