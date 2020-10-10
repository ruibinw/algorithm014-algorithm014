package binary_tree_validate_bst;

import binary_tree.TreeNode;

/**
 * 递归带着上下边界
 */
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        if (!isValidBST(root.left, min, root.val)) return false;
        if (!isValidBST(root.right, root.val, max)) return false;
        return true;
    }
}

/**
 * 中序遍历
 */
class Solution2 {
    private long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        //terminator
        if (root == null)
            return true;
        //left child check
        if (!isValidBST(root.left))
            return false;
        //current node check and update prev
        if (prev >= root.val)
            return false;
        prev = root.val;
        //right child check
        if (!isValidBST(root.right))
            return false;
        //left-mid-right are all valid, then return true
        return true;
    }
}
