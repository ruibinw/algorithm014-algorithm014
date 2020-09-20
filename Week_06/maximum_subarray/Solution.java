package maximum_subarray;

import java.util.Arrays;
import java.util.Collections;

/**
 * 暴力法
 * Time: O(n^2)
 * Space: O(1)
 */
class Solution1 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
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
    public int maxSubArray(int[] nums) {
        Integer[] sum = new Integer[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
        }
        return Collections.max(Arrays.asList(sum));
    }
}

/**
 * 动态规划, 优化空间，一个变量保存状态
 * Time: O(n)
 * Space: O(1)
 */
class Solution3 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
