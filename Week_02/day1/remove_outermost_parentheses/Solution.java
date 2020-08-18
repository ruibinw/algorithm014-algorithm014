package remove_outermost_parentheses;

/**
 * 双指针
 */
class Solution1 {
    public static void main(String[] args) {
        String s = "((()))(()())(())";
        String s1 = new Solution1().removeOuterParentheses(s);
        System.out.println(s1);
    }
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

class Solution2 {
    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
}
