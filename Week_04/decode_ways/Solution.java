package decode_ways;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归 + 缓存
 * Time: O(n)，加了缓存不用重复计算
 * Space：O(n)，递归最深有 n 层
 */
class Solution1 {
    public int numDecodings(String s) {
        return s.length() == 0 ? 0 : numDecodings(s, 0, new HashMap<>());
    }
    private int numDecodings(String s, int i, Map<Integer, Integer> memo) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (memo.containsKey(i)) return memo.get(i);
        //1
        int count = numDecodings(s, i + 1, memo);
        //2
        if (i < s.length() - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))
            count += numDecodings(s, i + 2, memo);

        memo.put(i, count);
        return count;
    }
}

/**
 * dp，O(n), O(n)
 */
class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

/**
 * dp，O(n), O(1)
 */
class Solution3 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int pre = 1, cur = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int next = 0;

            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one >= 1 && one <= 9) {
                next += cur;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                next += pre;
            }
            pre = cur;
            cur = next;
        }
        return cur;
    }
}
