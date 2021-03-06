package n_ary_tree_postorder_traversal;

import n_ary_tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * DFS
 */
class Solution1 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            dfs(child, res);
        }
        res.add(root.val);
    }
}

/**
 * BFS, reverse push
 */
class Solution2 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }
}

/**
 * BFS,
 */
class Solution3 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            Node p = stack.pop();
            if (p != null) {
                stack.push(p);
                stack.push(null);
                for (int i = p.children.size() - 1; i >= 0 ; i--) {
                    stack.push(p.children.get(i));
                }
            } else {
                result.add(stack.pop().val);
            }
        }
        return result;
    }
}