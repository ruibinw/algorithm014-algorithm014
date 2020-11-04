package valid_sudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用哈希表 HashSet记录，add方法，元素不存在返回 true
 */
class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                if (!set.add(num + "in row" + i) ||
                    !set.add(num + "in col" + j) ||
                    !set.add(num + "in box" + i/3 + "," + j/3 ))
                    return false;
            }
        }
        return true;
    }
}

/**
 * 使用数组记录
 * 运行时间比使用哈希表记录更快，但是占用更多空间 （一空间换时间）
 */
class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] existInRow = new boolean[9][10];
        boolean[][] existInCol = new boolean[9][10];
        boolean[][] existInBox = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0', k = (i / 3) * 3 + j / 3;
                if (existInRow[i][num] || existInCol[j][num] || existInBox[k][num])
                    return false;
                existInRow[i][num] = true;
                existInCol[j][num] = true;
                existInBox[k][num] = true;
            }
        }
        return true;
    }
}
