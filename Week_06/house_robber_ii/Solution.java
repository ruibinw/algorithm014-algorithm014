package house_robber_ii;

/**
 * 动态规划
 * 把环状排列的房子简化为两个单排列的
 * 1. 偷第一个，不偷最后一个
 * 2. 偷最后一个，不偷第一个
 * 最大金额 = 两种情况的较大值
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums != null ? nums.length : 0;
        if (n < 2) {
            return n == 0 ? 0 : nums[0];
        }
        return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
    }
    public int rob(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i < end; i++) {
            int next = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
