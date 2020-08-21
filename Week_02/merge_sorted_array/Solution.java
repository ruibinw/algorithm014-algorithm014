package merge_sorted_array;

import java.util.Arrays;

/**
 * 暴力法
 * 时间复杂度：O((m+n)log(m+n))
 * 空间复杂度：O(1)
 */
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
/**
 * 双指针、从后往前
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >=0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
