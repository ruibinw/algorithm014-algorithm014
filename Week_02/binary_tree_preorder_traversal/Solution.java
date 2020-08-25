package binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归
 */
class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        traversal(root.left, res);
        traversal(root.right, res);
    }
}

/**
 * 迭代
 */
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            if ((root = stack.pop()) == null)
                continue;
            result.add(root.val);
            stack.push(root.right);
            stack.push(root.left);
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
