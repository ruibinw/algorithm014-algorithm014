package valid_anagram;

import java.util.Arrays;

/**
 * 排序后比较
 * 时间复杂度：排序 O(nlogn) + 数组比较 O(n) => O(nlogn)
 * 空间复杂度：Java将字符串转成 char[] 时要进行拷贝 = O(n)，其他语言一般是 O(1)
 */
class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        new StringBuilder(s);
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

/**
 * 哈希表 / 计数器
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {
    public static void main(String[] args) {
        new Solution2().isAnagram("a","b");
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charCount[t.charAt(i) - 'a']--;
            if (charCount[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
