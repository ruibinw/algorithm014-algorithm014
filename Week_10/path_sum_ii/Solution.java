package path_sum_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 */
class Solution1 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0)
            res.add(new ArrayList(path));

        dfs(root.left, sum, res, path);
        dfs(root.right, sum, res, path);
        path.remove(path.size() - 1);
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
