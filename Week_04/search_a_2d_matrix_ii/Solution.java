package search_a_2d_matrix_ii;

/**
 * 减而治之
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = (matrix != null) ? matrix.length : 0;
        int n = (matrix.length > 0) ? matrix[0].length : 0;

        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                i--;
            else
                j++;
        }
        return false;
    }
}
