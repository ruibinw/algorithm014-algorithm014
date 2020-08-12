package three_sum;

import java.util.*;

//https://leetcode-cn.com/problems/3sum/

/**
 * 暴力法 (三重循环）
 * 时间复杂度：O(nlogn) + O(n^3) => O(n^3)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2)
            return Collections.emptyList();

        Arrays.sort(nums);//结果不需要下标，所以可以排序
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0)
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return new ArrayList<>(result);
    }
}

/**
 * 双指针 + 去重数据降低时间复杂度
 * 时间复杂度：O(nlogn) + O(n^2) => O(n^2)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n;
        if (nums == null || (n = nums.length) < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++; hi--;
                }
                else if (sum < 0) lo++;
                else if (sum > 0) hi--;
            }
        }
        return result;
    }
}

