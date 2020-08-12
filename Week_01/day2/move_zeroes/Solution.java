package move_zeroes;

//https://leetcode-cn.com/problems/move-zeroes

/**
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int firstZeroAt;
        for (firstZeroAt = 0; firstZeroAt < nums.length; firstZeroAt++)
            if (nums[firstZeroAt] == 0) break;

        for (int i = firstZeroAt + 1; i < nums.length; i++)
            if (nums[i] != 0) {
                nums[firstZeroAt++] = nums[i];
                nums[i] = 0;
            }
    }
}
