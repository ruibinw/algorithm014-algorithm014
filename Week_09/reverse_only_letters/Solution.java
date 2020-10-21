package reverse_only_letters;

import java.util.Stack;

/**
 * 子母栈 O(n)，O(n)
 */
class Solution1 {
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                res.append(stack.pop());
            else
                res.append(c);
        }
        return res.toString();
    }
}

/**
 * 双指针 O(n)，O(n)
 */
class Solution2 {
    public String reverseOnlyLetters(String S) {
        char[] c = S.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            if (!Character.isLetter(c[i])) i++;
            else if (!Character.isLetter(c[j])) j--;
            else { char tmp = c[i]; c[i++] = c[j]; c[j--] = tmp; }
        }
        return new String(c);
    }
}
