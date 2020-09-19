package n_ary_tree_preorder_traversal;

import n_ary_tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * DFS
 */
class Solution1 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            dfs(child, res);
        }
    }
}

/**
 * BFS
 */
class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0 ; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}