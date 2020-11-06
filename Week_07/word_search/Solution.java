package word_search;

/**
 * 暴力法，dfs，回溯
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == word.charAt(0)) {
                    if (exist(board, x, y, word, 0)) return true;
                }
            }
        }
        return false;
    }

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean exist(char[][] board, int x, int y, String word, int i) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(i))
            return false;

        if (i == word.length() - 1)
            return true;

        board[x][y] = '*';
        for (int[] d : directions)
            if (exist(board, x + d[0], y + d[1], word, i + 1)) return true;

        board[x][y] = word.charAt(i);
        return false;
    }
}
