package reverse_words_in_a_string;

import java.util.Arrays;
import java.util.Collections;

/**
 * 使用内置函数，分割+反转
 * O(n), O(n)
 */
class Solution1 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}

/**
 * 双指针，倒序遍历
 * O(n), O(n)
 */
class Solution2 {
    public String reverseWords(String s) {
        StringBuilder words = new StringBuilder();
        int i = s.length() - 1, j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            words.append(s, i + 1, j + 1).append(" ");
        }
        return words.toString().trim();
    }
}
