package invert_binary_tree;

import binary_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * DFS
 */
class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            swapChildren(root);
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

/**
 * BFS
 */
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            swapChildren(t);
            if (t.left != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
        }
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
