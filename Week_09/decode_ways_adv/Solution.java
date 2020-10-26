package decode_ways_adv;

class Solution1 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = oneNumDecode(s, dp, 1);
        for (int i = 2; i <= n; i++) {
            //当前的解码方式总数 = （在前 1步字符串上尝试加 1个数 的解码方式总数） + （在前 2步字符串上尝试加 2个数 的解码方式总数）
            dp[i] = oneNumDecode(s, dp, i) + twoNumDecode(s, dp, i);
        }
        return dp[n];
    }

    //判断 前两步的字符串 s[i-2] 加上 当前的两个数 是否是有效的解码
    //是：返回 前两步的解码方式总数
    //否：返回 0
    private int twoNumDecode(String s, int[] dp, int i) {
        return s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') ? dp[i - 2] : 0;
    }

    //判断 前一步的字符串 s[i-1] 加上 当前的一个数 是否是有效的解码
    //是：返回 前一步的解码方式总数
    //否：返回 0
    private int oneNumDecode(String s, int[] dp, int i) {
        return s.charAt(i - 1) != '0' ? dp[i - 1] : 0;
    }
}


class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int prev = 1, curr = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int next = 0;
            if (s.charAt(i - 1) != '0') {
                next += curr;
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                next += prev;
            }
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
