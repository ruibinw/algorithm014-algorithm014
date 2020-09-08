package minesweeper;

/**
 * DFS
 */
class Solution {
    private char[][] board;
    private int rows;
    private int cols;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        int x = click[0], y = click[1];
        if (board[x][y] == 'M')
            board[x][y] = 'X';
        else
            revealBoard(x, y);
        return board;
    }

    private void revealBoard(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] != 'E') return;
        char mines = countAdjMines(x, y);
        if (mines > '0') {
            board[x][y] = mines;
        } else {
            board[x][y] = 'B';
            for (int[] d : directions) {
                revealBoard(x + d[0], y + d[1]);
            }
        }
    }

    private char countAdjMines(int x, int y) {
        char count = '0';
        for (int[] d : directions) {
            int dx = x + d[0], dy = y + d[1];
            if (dx >= 0 && dx < rows && dy >= 0 && dy < cols && board[dx][dy] == 'M')
                count++;
        }
        return count;
    }
}
