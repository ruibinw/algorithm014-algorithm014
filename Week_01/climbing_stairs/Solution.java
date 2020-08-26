package climbing_stairs;

//https://leetcode-cn.com/problems/climbing-stairs/

import java.util.HashMap;
import java.util.Map;

/**
 * 递归求解
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(n)
 */
class Solution1 {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n < 3) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

/**
 * 递归+缓存器
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) return n;
        if (cache.containsKey(n)) return cache.get(n);
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, res);
        return res;
    }
}

/**
 * 动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution3 {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n < 3) return n;
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++) {
            int next = pre + cur;
            pre = cur;
            cur = next;
        }
        return cur;
    }
}
