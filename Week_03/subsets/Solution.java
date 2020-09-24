package subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯
 * Time：O(2^n)，n个格子，每个格子有 2 种选择
 * Space：O(n)，递归的最深度，O(2^n)结果的个数
 */
class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, 0, nums.length, new ArrayList<>());
        return ans;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, int i, int n, List<Integer> list) {
        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        //选择放
        list.add(nums[i]);
        dfs(nums, ans, i + 1, n, list);
        //选择不放
        list.remove(list.size() - 1);
        dfs(nums, ans, i + 1, n, list);
    }
}

/**
 * 循环
 */
class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.EMPTY_LIST);
        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : res) {
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                temp.add(newList);
            }
            res.addAll(temp);
        }
        return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution3().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
