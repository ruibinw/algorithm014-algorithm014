package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 * Time: O(2^n)，每个数字可放可不放 2种选择
 * Space: O(n) 递归深度，O(n!/((n-k)!k!))
 */
class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, n, k, new ArrayList<>(), 1);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, int n, int k, List<Integer> list, int i) {
        if (i > n) {
            return;
        }
        if (list.size() == k) {
            ans.add(new ArrayList(list));
            return;
        }
        list.add(i);
        dfs(ans, n, k, list, i + 1);
        list.remove(list.size() - 1);
        dfs(ans, n, k, list, i + 1);
    }
}

/**
 * 回溯 + 剪枝
 */
class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, n, k, new ArrayList<>(), 1);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, int n, int k, List<Integer> list, int i) {
        //剪枝：list长度加上区间 [i, n] 的长度小于 k，不可能构造出长度为 k 的组合
        if (list.size() + (n - i + 1) < k) {
            return;
        }
        if (list.size() == k) {
            ans.add(new ArrayList(list));
            return;
        }
        list.add(i);
        dfs(ans, n, k, list, i + 1);
        list.remove(list.size() - 1);
        dfs(ans, n, k, list, i + 1);
    }
}
