package binary_tree_level_order_traversal;

import binary_tree.TreeNode;

import java.util.*;

/**
 * BFS
 * Time：O(n)
 * Space：O(n)
 */
class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}

/**
 * DFS
 * Time：O(n)
 * Space：O(n)
 */
class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(res, root, 0);
        return res;
    }

    private void levelOrder(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;

        if (res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(root.val);

        levelOrder(res, root.left, level + 1);
        levelOrder(res, root.right, level + 1);
    }
}
