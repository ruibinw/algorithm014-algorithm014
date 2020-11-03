package generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出所有左右括号的组合（无论是否有效的括号组合）
 */
class Test {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0,n * 2, "", result);
        return result;
    }

    private void generate(int level, int max, String s, List<String> result) {
        if (level >= max) {
            result.add(s);
            return;
        }
        generate(level + 1, max, s + "(", result);
        generate(level + 1, max, s + ")", result);
    }

    public static void main(String[] args) {
        List<String> list = new Test().generateParenthesis(3);
        System.out.println(list);
    }

}

/**
 * 回溯 + 剪枝
 * 在调用递归前做判断有效的括号拼接
 * 剪枝条件
 * - 左括号个数不能大于 n
 * - 先有了左括号后才能加右括号 right < left
 */
class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String s, int L, int R, int n) {
        if (L == n && R == n) {
            result.add(s);
            return;
        }
        if (L < n) generate(result, s + "(", L + 1, R, n);
        if (R < L) generate(result, s + ")", L, R + 1, n);
    }

    public static void main(String[] args) {
        List<String> list = new Solution1().generateParenthesis(2);
        System.out.println(list);
    }
}

/**
 * 使用 StringBuilder，优化空间性能
 */
class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, ans, new StringBuilder(), 0, 0);
        return ans;
    }
    private void generateParenthesis(int n, List<String> ans, StringBuilder s, int L, int R) {
        if (s.length() == 2*n) {
            ans.add(s.toString());
        }
        if (L < n) {
            generateParenthesis(n, ans, s.append("("), L + 1, R);
            s.deleteCharAt(s.length() - 1);
        }
        if (R < L) {
            generateParenthesis(n, ans, s.append(")"), L, R + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
