package first_unique_char_in_a_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表记录字符出现的次数 O(n)，O(n)
 */
class Solution {
    public int firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> count = new HashMap<>();

        for (char c : cs)
            count.put(c, count.getOrDefault(c, 0) + 1);

        for (int i = 0; i < s.length(); i++)
            if (count.get(cs[i]) == 1) return i;

        return -1;
    }
}
