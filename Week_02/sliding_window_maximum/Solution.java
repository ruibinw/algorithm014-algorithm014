package sliding_window_maximum;

import java.util.*;

/**
 * 暴力法
 * 时间复杂度：O(n*k)
 * 空间复杂度：O(n-k+1)
 */
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resultSize = nums.length - k + 1;
        int[] result = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            result[i] = max;
        }
        return result;
    }
}

/**
 * 利用队列，面向过程的写法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n-k+1) + O(k) = O(n)
 */
class Solution2 {

    private class MaxQueue {
        Deque<Integer> queue = new ArrayDeque<>();

        void push(int data) {
            while (!queue.isEmpty() && queue.peekLast() < data)
                queue.pollLast();
            queue.offerLast(data);
        }

        void pop(int data) {
            if (queue.peekFirst() == data) queue.pollFirst();
        }

        int max() {
            return queue.peekFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MaxQueue window = new MaxQueue();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                result[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return result;
    }

}

/**
 * 动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n-k+1) + O(n) + O(n) = O(n)
 */
class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] maxLeft = new int[n];
        maxLeft[0] = nums[0];

        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];

        //Traverse the list from start to end and calculate max_so_far. Reset max after each block boundary (of k elements)
        for (int i = 1; i < n; i++) {
            maxLeft[i] = (i % k == 0) ? nums[i] : Math.max(maxLeft[i - 1], nums[i]);
        }
        //Similarly calculate max in future by traversing from end to start
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = ((i + 1) % k == 0) ? nums[i] : Math.max(maxRight[i + 1], nums[i]);
        }

        //sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            result[i] = Math.max(maxLeft[i + k - 1], maxRight[i]);
        }
        return result;
    }
}
