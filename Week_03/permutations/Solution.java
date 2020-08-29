package permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        findPermutations(nums, new ArrayList<>());
        return res;
    }

    private void findPermutations(int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            findPermutations(nums, new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
