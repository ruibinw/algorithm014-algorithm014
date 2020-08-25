package binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归
 */
class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }
}

/**
 * 迭代
 */
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p != null) {
                stack.push(p);
                stack.push(null);
                if (p.right != null) stack.push(p.right);
                if (p.left != null) stack.push(p.left);
            } else {
                p = stack.pop();
                result.add(p.val);
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
