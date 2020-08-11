package climbing_stairs;

//https://leetcode-cn.com/problems/climbing-stairs/

import java.util.HashMap;

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
 * 递归+备忘录
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<Integer, Integer>());
    }
    private int climbStairs(int n, HashMap<Integer, Integer> mem) {
        if (n < 0) return 0;
        if (n < 3) return n;
        if (mem.containsKey(n)) return mem.get(n);
        int result = climbStairs(n - 1, mem) + climbStairs(n - 2, mem);
        mem.put(n, result);
        return result;
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
