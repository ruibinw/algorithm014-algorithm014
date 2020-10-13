package merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 根据每个区间的起始点排序，再进行两两合并
 * Time：O(nlogn)，排序使用的时间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];

        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            if (intervals[j][0] > res[i][1]) {
                res[++i] = intervals[j];
            } else {
                res[i][1] = Math.max(res[i][1], intervals[j][1]);
            }
        }
        return Arrays.copyOf(res, i + 1);
    }
}
