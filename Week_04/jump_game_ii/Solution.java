package jump_game_ii;

/**
 * This is an implicit bfs solution.
 * i == endpoint means you visited all the items on the current level.
 * Incrementing jumps++ is like incrementing the level you are on.
 * And endpoint = maxDist is like getting the queue size (level size) for the next level you are traversing.
 */
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, endpoint = 0, maxDist = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDist = Math.max(maxDist, i + nums[i]);
            if (i == endpoint) {
                if (maxDist == endpoint) return -1;//说明不能跳到最后格子
                jumps++;
                endpoint = maxDist;
            }
        }
        return jumps;
    }
}
