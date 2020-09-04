package decode_ways;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归 + 缓存
 * Time: O(n)，加了缓存不用重复计算
 * Space：O(n)，递归最深有 n 层
 */
class Solution {
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
