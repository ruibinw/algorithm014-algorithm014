package remove_duplicates_from_sorted_array;

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

/**
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)，原地修改
 */
class solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
