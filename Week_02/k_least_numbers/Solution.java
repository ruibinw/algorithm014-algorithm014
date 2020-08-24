package k_least_numbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 排序取前k
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)，排序是快排，递归过程额外占用的空间
 */
class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}

/**
 * 大顶堆
 * 时间复杂度：O(nlogk)，最坏情况 n个元素都会被插入
 * 空间复杂度：O(k)
 */
class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }

        return maxHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 快速选择
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        return null;
    }
}