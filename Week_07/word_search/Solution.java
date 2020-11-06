package word_search;

/**
 * 暴力法，dfs，回溯
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean dfs(char[][] board, int i, int j, String word, int ci) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ci))
            return false;

        if (ci == word.length() - 1)
            return true;

        char original = board[i][j];
        board[i][j] = '*';
        for (int[] d : directions) {
            if (dfs(board, i + d[0], j + d[1], word, ci + 1))
                return true;
        }
        board[i][j] = original;
        return false;
    }
}
