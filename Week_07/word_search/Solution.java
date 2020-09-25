package word_search;

/**
 * 暴力法，dfs，回溯
 */
class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int ci, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(ci))
            return false;

        if (ci == word.length() - 1)
            return true;

        char original = board[i][j];
        board[i][j] = '@';//标记当前元素为访问过
        for (int k = 0; k < 4; k++) {
            if(exist(board, word, ci + 1, i + directions[k][0], j + directions[k][1])) {
                return true;
            }
        }
        board[i][j] = original;//进行回溯：尝试上下左右搜索后，还原当前元素
        return false;
    }
}
