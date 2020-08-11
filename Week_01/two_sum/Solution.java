package two_sum;

//https://leetcode-cn.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

/**
 * 暴力法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }
}

/**
 * 使用哈希表记录元素的值和位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x))
                return new int[]{map.get(x), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
