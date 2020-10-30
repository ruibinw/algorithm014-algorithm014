package serialize_and_deserialize_binary_tree;

/**
 * DFS
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder()).toString();
    }
    private StringBuilder serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            return str.append("N,");
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
    int i = -1;
    private TreeNode buildBinaryTree(String[] strNodes) {
        String val = strNodes[++i];
        if (val.equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildBinaryTree(strNodes);
        root.right = buildBinaryTree(strNodes);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        Codec codec = new Codec();
        String s = codec.serialize(root);
        TreeNode t = codec.deserialize(s);
        System.out.println();
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
