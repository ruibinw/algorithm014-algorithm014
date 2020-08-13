package move_zeroes;

//https://leetcode-cn.com/problems/move-zeroes

/**
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, firstZeroAt = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[firstZeroAt];
                nums[firstZeroAt++] = temp;
            }
    }
}
