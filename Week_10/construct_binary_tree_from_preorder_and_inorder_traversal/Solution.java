package construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归
 */
class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pi, int[] inorder, int start, int end) {
        if (pi > preorder.length - 1 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pi]);
        int ri = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                ri = i;
                break;
            }
        }
        root.left = buildTree(preorder, pi + 1, inorder, start, ri - 1);
        root.right = buildTree(preorder, pi + ri - start + 1, inorder, ri + 1, end);
        return root;
    }

    public static void main(String[] args) {
        new Solution1().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}

/**
 * 使用哈希表记录 inorder的元素，减少循环查找下标，提高时间复杂度
 * 因为是 DFS，回显构建左子树，所以可以按顺序取出 preorder的元素作为某个子树的根节点
 */
class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorderMap, 0, inorder.length - 1);
    }

    int pi = 0;
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int start, int end) {
        if (pi > preorder.length - 1 || start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pi++]);
        int ri = inorderMap.get(root.val);
        root.left = buildTree(preorder, inorderMap, start, ri - 1);
        root.right = buildTree(preorder, inorderMap, ri + 1, end);
        return root;
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
