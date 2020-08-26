package valid_parentheses;

//https://leetcode-cn.com/problems/valid-parentheses/

import java.util.*;

/**
 * 暴力法，替换掉括号对
 */
class Solution1 {
    public boolean isValid(String s) {
        while (s.indexOf("()") > -1 || s.indexOf("[]") > -1 || s.indexOf("{}") > -1) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.length() == 0;
    }
}

/**
 * 利用栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution2 {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default : if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }
}


class Solution3 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
