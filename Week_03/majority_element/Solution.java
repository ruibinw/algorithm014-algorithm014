package majority_element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 暴力法，排序后取中间
 * Time = O(nlogn)
 * Space = O(1)
 */
class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/**
 * 哈希表
 * Time = O(n)
 * Space = O(n)
 */
class Solution2 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int half = nums.length / 2;
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            if (count >= half) return num;
            countMap.put(num,  count + 1);
        }
        return 0;
    }
}

/**
 * Boyer-Moore 投票算法
 * Time = O(n)
 * Space = O(1)
 */
class Solution3 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            count += (num == candidate) ? 1 : -1;
            if (count == 0) {
                candidate = num;
                count = 1;
            }
        }
        return candidate;
    }
}

/**
 * 分治法
 * Time =
 * Space =
 */
class Solution4 {

}
