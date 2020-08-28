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
        int val = root.val;
        if (val > min && val < max && isValidBST(root.left, min, val) && isValidBST(root.right, val, max))
            return true;
        return false;
    }
}

/**
 * 中序遍历
 */
class Solution2 {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        //terminator
        if (root == null) return true;
        //left child check
        if (isValidBST(root.left) == false) return false;
        //current node check and update prev
        if (prev >= root.val) return false;
        prev = root.val;
        //right child check
        if (isValidBST(root.right) == false) return false;
        return true;
    }
}
