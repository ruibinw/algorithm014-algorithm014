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
        if (heights == null || heights.length == 0) return 0;

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
 * 动态规划提前计算出左右边界
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;
        int[] leftIndex = new int[n];
        int[] rightIndex = new int[n];
        leftIndex[0] = -1;
        rightIndex[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = leftIndex[p];
            }
            leftIndex[i] = p;
        }

        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i]) {
                p = rightIndex[p];
            }
            rightIndex[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (rightIndex[i] - leftIndex[i] - 1) * heights[i]);
        }
        return maxArea;
    }
}

/**
 * 使用栈，以空间换时间
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution3 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; ) {
            int h = (i == n ? 0 : heights[i]);
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
