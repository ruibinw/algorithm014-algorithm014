package largest_rectangular_in_histogram;

//https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

import java.util.Arrays;
import java.util.Stack;

/**
 * 暴力法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int mid = 0; mid < n; mid++) {
            int left = mid;
            while (left > 0 && heights[left - 1] >= heights[mid]) {
                left--;
            }
            int right = mid;
            while (right < n - 1 && heights[right + 1] >= heights[mid]) {
                right++;
            }
            int area = heights[mid] * (right - left + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

/**
 * 使用栈，以空间换时间
 * 时间复杂度：O(n)
 * 空间复杂度：
 */
class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; ) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }
}
