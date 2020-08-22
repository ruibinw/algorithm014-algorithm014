package binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归
 * 时间复杂度：O(n)
 * 空间复杂度：平均 O(logn)，最坏树退化成链表 O(n)
 */
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

}

/**
 * 迭代 + 栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(logn), 栈存放最多元素是树的高度
 */
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //使用栈模拟递归的调用过程
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}

/**
 * Definition of TreeNode
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
