package walking_robot_simulation;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) {
                dir = dir == 3 ? 0 : dir + 1;
            } else if (c == -2) {
                dir = dir == 0 ? 3 : dir - 1;
            } else {
                int[] xy = dirs[dir];
                while (c-- > 0 && !set.contains((x + xy[0]) + "," + (y + xy[1]))) {
                    x += xy[0];
                    y += xy[1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
