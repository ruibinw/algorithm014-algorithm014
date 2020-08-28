package binary_tree_min_depth;

import binary_tree.TreeNode;

/**
 * 递归
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left), right = minDepth(root.right);

        if (root.left == null) return right + 1;
        if (root.right == null) return left + 1;

        return Math.min(left, right) + 1;
    }
}
