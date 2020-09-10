package jump_game;

import java.util.HashMap;

/**
 * DFS，递归
 */
class Solution1 {
    public boolean canJump(int[] nums) {
        return jumpTo(nums, 0);
    }

    private boolean jumpTo(int[] nums, int i) {
        if (i >= nums.length - 1)
            return true;
        for (int step = nums[i]; step > 0; step--) {
            if (jumpTo(nums, i + step)) return true;
        }
        return false;
    }
}

/**
 * DFS, 递归 + 缓存
 */
class Solution2 {
    public boolean canJump(int[] nums) {
        return jumpTo(nums, 0, new HashMap<>());
    }

    private boolean jumpTo(int[] nums, int i, HashMap<Integer, Boolean> cache) {
        if (i >= nums.length - 1)
            return true;
        if (cache.containsKey(i))
            return cache.get(i);
        for (int step = nums[i]; step > 0; step--) {
            if (jumpTo(nums, i + step, cache)) {
                cache.put(i + step, true);
                return true;
            }
        }
        cache.put(i, false);
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[25003];
        for (int i = 0; i <= 25000; i++) {
            nums[i] = 25000 - i;
        }
        nums[25000] = 1;
        nums = new int[]{1, 2, 3, 4, 5};
        boolean b = new Solution2().canJump(nums);
        System.out.println(b);
    }
}

/**
 * 贪心法
 */
class Solution3 {
    public boolean canJump(int[] nums) {
        int maxDistanceSofar = 0;
        for (int i = 0; i <= maxDistanceSofar; i++) {
            int curJumpDistance = i + nums[i];
            maxDistanceSofar = Math.max(maxDistanceSofar, curJumpDistance);
            if (maxDistanceSofar >= nums.length - 1) return true;
        }
        return false;
    }
}
