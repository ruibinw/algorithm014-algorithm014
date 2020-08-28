package binary_tree_max_depth;

import binary_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 递归 DFS
 * 时间复杂度：O(n)，每个节点被访问一次
 * 空间复杂度：O(logn)
 */
class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

/**
 * BFS + 队列
 * 时间复杂度：O(n)，每个节点被访问一次
 * 空间复杂度：O(n)
 */
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return depth;
    }
}
