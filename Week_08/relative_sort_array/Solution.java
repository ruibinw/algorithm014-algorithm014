package relative_sort_array;

import java.util.Map;
import java.util.TreeMap;

/**
 * 计数排序 + BST
 * Time：O(nlogn)，n = arr1.length
 * Space: O(n)
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> bst = new TreeMap<>();//Binary Search Tree
        for (int num : arr1) bst.put(num, bst.getOrDefault(num, 0) + 1);

        int i = 0;
        for (int num : arr2) {
            for (int j = 0; j < bst.get(num); j++) {
                arr1[i++] = num;
            }
            bst.remove(num);
        }
        for (int num : bst.keySet()) {
            for (int j = 0; j < bst.get(num); j++) {
                arr1[i++] = num;
            }
        }
        return arr1;
    }
}
