package to_lower_case;

/**
 * 利用ASCII值，大小写的相差 = 32
 */
class Solution1 {
    public String toLowerCase(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            s.append(c >= 'A' && c <= 'Z' ? (char)(c + 32) : c);
        }
        return s.toString();
    }
}

/**
 * 位运算
 * 大写变小写、小写变大写 : 字符 ^= 32;
 * 大写变小写、小写变小写 : 字符 |= 32;
 * 小写变大写、大写变大写 : 字符 &= -33;
 */
class Solution2 {
    public String toLowerCase(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            c[i] |= 32;
        }
        return new String(c);
    }
}
