package permutations;

import java.util.ArrayList;
import java.util.List;

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
