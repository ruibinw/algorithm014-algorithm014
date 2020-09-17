package permutations_ii;

import java.util.*;

/**
 * 回溯，在叶子节点判断重复
 * Time: O(n * n!)
 */
class Solution1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length], new HashSet<>());
        return res;
    }
    int count = 0;
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used, Set<String> resultCheck) {
        if (list.size() == nums.length) {
            String listStr = list.toString();
            if (!resultCheck.contains(listStr)) {
                res.add(new ArrayList<>(list));
                resultCheck.add(listStr);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            System.out.println(count++);
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, res, list, used,resultCheck);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new Solution1().permuteUnique(new int[]{1, 1, 2});
        System.out.println(list);
    }
}

/**
 * 回溯 + 剪枝
 */
class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);//剪枝条件的前提
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, res, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution2().permuteUnique(new int[]{1, 1, 2, 2});
        System.out.println(list);
    }
}
