package remove_outermost_parentheses;

/**
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)，使用了额外空间存放最终答案
 */
class Solution1 {
    public String removeOuterParentheses(String S) {
        int left = 1, right = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                left++;
            else
                right++;

            if (left != right) {
                result.append(S.charAt(i));
            } else {
                left = 1;
                right = 0;
                i++;
            }
        }
        return result.toString();
    }
}

/**
 * 使用计数器
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)，使用了额外空间存放最终答案
 */
class Solution2 {
    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder(); S.substring(1,1);
        int opened = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
}
