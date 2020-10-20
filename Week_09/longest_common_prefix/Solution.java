package longest_common_prefix;

/**
 * 纵向扫描 O(mn)，O(1)
 * n = 字符串个数
 * m = 最小字符串的长度
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        for (int ci = 0; ci < strs[0].length(); ci++) {
            for (int si = 1; si < strs.length; si++) {
                if (ci == strs[si].length() || strs[0].charAt(ci) != strs[si].charAt(ci))
                    return strs[0].substring(0, ci);
            }
        }
        return strs[0];
    }
}
