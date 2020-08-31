package top_k_frequent_elements;

import java.util.*;

/**
 * 哈希表 + 小顶堆
 * Time: O(nlogk)
 * Space: O(n)
 */
class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
            } else {
                if (map.get(key) > map.get(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.add(key);
                }
            }
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 哈希表 + 桶排序
 * Time: O(n)
 * Space: O(n)
 */
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && list.size() < k; i--) {
            if (bucket[i] != null) list.addAll(bucket[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
