package container_with_most_water;

//https://leetcode-cn.com/problems/container-with-most-water/

/**
 * 暴力法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}

/**
 * 左右边界（双指针）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = (height[i] < height[j]) ?
                    Math.max(maxArea, (j - i) * height[i++]):
                    Math.max(maxArea, (j - i) * height[j--]);
        }
        return maxArea;
    }
}
