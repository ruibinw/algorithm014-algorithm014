package path_sum;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * DFS
 * O(n), O(logn)
 */
class Solution1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

/**
 * BFS
 * O(n), O(n)
 */
class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        Queue<TreeNode> nq = new ArrayDeque<>(){{offer(root);}};
        Queue<Integer> sq = new ArrayDeque<>(){{offer(root.val);}};

        while (!nq.isEmpty()) {
            TreeNode node = nq.poll();
            Integer tsum = sq.poll();
            if (node.left == null && node.right == null && tsum == sum) {
                return true;
            }
            if (node.left != null) {
                nq.offer(node.left);
                sq.offer(tsum + node.left.val);
            }
            if (node.right != null) {
                nq.offer(node.right);
                sq.offer(tsum + node.right.val);
            }
        }
        return false;
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
