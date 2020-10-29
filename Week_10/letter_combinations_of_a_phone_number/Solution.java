package letter_combinations_of_a_phone_number;

import java.util.*;

/**
 * dfs
 */
class Solution1 {
    String[] lettersMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(digits, new StringBuilder(), 0, res);
        return res;
    }

    private void dfs(String digits, StringBuilder path, int i, List<String> res) {
        if (i == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = lettersMap[digits.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            path.append(c);
            dfs(digits, path, i + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

/**
 * dfs
 */
class Solution2 {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        String[] lettersMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Queue<String> combinations = new LinkedList<>();
        combinations.add("");

        for (int i = 0; i < digits.length(); i++) {
            int size = combinations.size();

            for (int j = 0; j < size; j++) {
                String prefix = combinations.poll();
                String letters = lettersMap[digits.charAt(i) - '0'];

                for (int k = 0; k < letters.length(); k++) {
                    combinations.offer(prefix + letters.charAt(k));
                }
            }
        }
        return (List) combinations;
    }
}
