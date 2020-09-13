package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return res;

        Arrays.sort(nums);
        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                int c = b + 1, d = n - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[c], nums[d])));
                        while (c < d && nums[c] == nums[++c]) ;
                        while (c < d && nums[d] == nums[--d]) ;
                    }
                    else if (sum < target) c++;
                    else if (sum > target) d--;
                }
            }
        }
        return res;
    }
}
