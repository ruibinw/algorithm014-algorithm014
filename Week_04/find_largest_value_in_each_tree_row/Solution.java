package find_largest_value_in_each_tree_row;

import binary_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * DFS
 */
class Solution1 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        dfs(root, 0, max);
        return max;
    }

    private void dfs(TreeNode root, int level, List<Integer> max) {
        if (root == null) return;

        if (max.size() == level) max.add(root.val);
        else max.set(level, Math.max(root.val, max.get(level)));

        dfs(root.left, level + 1, max);
        dfs(root.right, level + 1, max);
    }
}

/**
 * BFS
 */
class Solution2 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.val > max) max = node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
