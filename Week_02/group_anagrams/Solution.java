package group_anagrams;

import java.util.*;

/**
 * 排序数组分类
 * 时间复杂度：O(n*klogk)，n 字符串的个数，k字符串的最大长度
 * 空间复杂度:
 */
class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }

}

/**
 * 按计数分类
 * 时间复杂度：O(n*k)
 * 空间复杂度:
 */
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {

            char[] count = new char[26];
            for (char c : s.toCharArray()) count[c - 'a']++;

            String key = String.valueOf(count);
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

}

/**
 * 按计数分类
 * 时间复杂度：O(n*k)
 * 空间复杂度:
 */
class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for (String s : strs) {
            int num = 1;
            for (char c : s.toCharArray()) num *= prime[c - 'a'];
            String key = Integer.toString(num);
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

}
