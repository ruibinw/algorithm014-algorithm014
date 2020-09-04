package binary_tree_min_depth;

import binary_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * DFS
 */
class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        return (root.left == null || root.right == null) ? d1 + d2 + 1 : Math.min(d1, d2) + 1;
//        if (root.left == null) return right + 1;
//        if (root.right == null) return left + 1;
//        return Math.min(left, right) + 1;
    }
}

/**
 * BFS
 */
class Solution2 {
    public int minDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            depth++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                if (t.left == null && t.right == null) return depth;
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return depth;
    }
}
