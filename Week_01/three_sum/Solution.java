package three_sum;

import java.util.*;

//https://leetcode-cn.com/problems/3sum/

/**
 * 暴力法，三重循环，使用Set集合去重
 * 数组需要事先排序，因为Set判重时调用ArrayList的equals方法（按顺序对比元素）
 * 时间复杂度：O(nlogn) + O(n^3) => O(n^3)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2)
            return Collections.emptyList();

        Arrays.sort(nums);
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
 * 排序 + 双指针 + 判重技巧
 * 时间复杂度：O(nlogn) + O(n^2) => O(n^2)
 * 空间复杂度：O(1)
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = nums.length - 1, target = 0 - nums[i];
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[++lo]);
                    while (lo < hi && nums[hi] == nums[--hi]);
                }
                else if (sum < target) lo++;
                else if (sum > target) hi--;
            }
        }
        return result;
    }
}

