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
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {

    }
}
