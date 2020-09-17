package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 * Time: O(n*n!)，调用回溯方法的次数
 * Space: O(n)，递归的深度，如果算上结果集 O(n!) 叶子节点（最终结果）的个数
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        findPermutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void findPermutations(int[] nums, ArrayList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            list.add(nums[i]);
            used[i] = true;

            findPermutations(nums, list, used);

            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
