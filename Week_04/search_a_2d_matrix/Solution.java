package search_a_2d_matrix;

/**
 * 二分查找
 * 把二维数组视为一维数组
 * Time：O(log mn)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = (matrix != null) ? matrix.length : 0;
        int n = (matrix.length > 0) ? matrix[0].length : 0;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int num = matrix[mid / n][mid % n];
            if (num == target)
                return true;
            else if (num < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
