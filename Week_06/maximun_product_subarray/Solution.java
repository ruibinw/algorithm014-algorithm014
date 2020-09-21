package maximun_product_subarray;

import java.util.Arrays;
import java.util.Collections;

/**
 * 暴力法：双重遍历，计算所有子序列的乘积
 * Time: O(n^2)
 * Space: O(1)
 */
class Solution1 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                max = Math.max(max, prod);
            }
        }
        return max;
    }
}

/**
 * 动态规划, 一维数组保存状态
 * Time: O(n)
 * Space: O(n)
 */
class Solution2 {
    public int maxProduct(int[] nums) {
        Integer[] curMax = new Integer[nums.length]; curMax[0] = nums[0];
        Integer[] curMin = new Integer[nums.length]; curMin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                curMax[i] = Math.max(curMax[i - 1] * nums[i], nums[i]);
                curMin[i] = Math.min(curMin[i - 1] * nums[i], nums[i]);
            } else {
                curMax[i] = Math.max(curMin[i - 1] * nums[i], nums[i]);
                curMin[i] = Math.min(curMax[i - 1] * nums[i], nums[i]);
            }
        }
        return Collections.max(Arrays.asList(curMax));
    }
}

/**
 * 动态规划, 优化
 * Time: O(n)
 * Space: O(1)
 */
class Solution3 {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }
        return maxSoFar;
    }
}
