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
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String s, int left, int right, int max) {
        if (left == max && right == max) {
            result.add(s);
            return;
        }
        if (left < max) {
            generate(result, s + "(", left + 1, right, max);
        }
        if (right < left) {
            generate(result, s + ")", left, right + 1, max);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution().generateParenthesis(2);
        System.out.println(list);
    }
}
