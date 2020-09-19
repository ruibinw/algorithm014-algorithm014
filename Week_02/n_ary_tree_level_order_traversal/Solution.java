package n_ary_tree_level_order_traversal;

import n_ary_tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * BFS
 */
class Solution1 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Node node = queue.poll();
                list.add(node.val);
                node.children.forEach(child -> queue.add(child));
            }
            ans.add(list);
        }
        return ans;
    }
}

/**
 * DFS
 */
class Solution2 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }
    private void dfs(Node root, List<List<Integer>> ans, int level) {
        if (root == null) return;

        if (ans.size() == level) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);

        root.children.forEach(child -> dfs(child, ans, level + 1));
    }

    public static void main(String[] args) {
        Node root = new Node(0, new ArrayList<>());
        new Solution2().levelOrder(root);
    }
}