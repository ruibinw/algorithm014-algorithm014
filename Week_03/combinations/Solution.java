package combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        findCombination(n, k, new ArrayList<>(), 1);
        return res;
    }

    private void findCombination(int n, int k, List<Integer> list, int start) {
        System.out.println(list);
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - (k - list.size()) + 1; i++) { //剪枝：把 i <= n 改成 i <= n - (k - list.size()) + 1
            list.add(i);
            findCombination(n, k, new ArrayList<>(list), i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution().combine(10, 5);
        System.out.println(list);
        System.out.println(list.size());
    }
}
