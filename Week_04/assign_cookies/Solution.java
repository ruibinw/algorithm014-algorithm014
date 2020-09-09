package assign_cookies;

import java.util.Arrays;

/**
 * 贪心法：优先用最小的饼干满足胃口最小的孩子
 * Just assign the cookies starting from the child with less greediness to maximize the number of happy children
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si])
                gi++;
            si++;
        }
        return gi;
    }
}
