package binary_tree_lowest_common_ancestor;

import binary_tree.TreeNode;

import java.util.*;

/**
 * 递归
 * Time: O(n) worst
 * Space: O(log n) worst
 */
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

/**
 * 栈 + 循环
 * 使用 map保存每个节点的父节点，遍历树直到找到 p 和 q
 * 遍历找出所有 p 的父节点放入set，再遍历找出 q 的父节点，第一个和set里重复的，就是公共祖先
 * Time: O(n)
 * Space: O(n)
 */
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
