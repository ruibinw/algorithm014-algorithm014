package serialize_and_deserialize_binary_tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS
 */
class Codec1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder()).toString();
    }
    private StringBuilder serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            return str.append("null,");
        }
        str.append(root.val).append(",");
        serialize(root.left, str);
        serialize(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return buildBinaryTree(data.split(","));
    }
    int i = 0;
    private TreeNode buildBinaryTree(String[] vals) {
        String val = vals[i++];
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildBinaryTree(vals);
        root.right = buildBinaryTree(vals);
        return root;
    }
}

/**
 * BFS
 */
class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                ans.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                ans.append("null,");
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            String leftVal = vals[i++];
            if (!leftVal.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.valueOf(leftVal));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            String rightVal = vals[i++];
            if (!rightVal.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(rightVal));
                node.right = rightNode;
                queue.offer(rightNode);
            }
        }
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
