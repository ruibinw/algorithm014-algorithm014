package reverse_pairs;

/**
 * 利用归并排序计算出逆序对的数目
 * Time：O(nlogn)
 * Space: O(n)
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int mid = (l + r) >>> 1;
        int count = mergeSortAndCount(nums, l, mid) + mergeSortAndCount(nums, mid + 1, r);

        //count important reverse pairs (i < j and nums[i] > 2*nums[j]
        for (int i = l, j = mid + 1; i <= mid; i++) {
            while (j <= r && nums[i] / 2.0 > nums[j]) j++;//use nums[i] / 2.0 to avoid 2*nums[j] from overflow
            count += j - (mid + 1);
            //no need to reset j to mid-1 after because nums[i+1] is always twice larger than nums[current j]
        }
        merge(nums, l, mid, r);
        return count;
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] cache = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            cache[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= m) cache[k++] = nums[i++];
        while (j <= r) cache[k++] = nums[j++];

        k = 0;
        while (k < cache.length) nums[l + k] = cache[k++];
    }
}
